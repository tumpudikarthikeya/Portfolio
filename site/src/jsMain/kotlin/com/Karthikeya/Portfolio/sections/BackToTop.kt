package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.*
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.BackToTopStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun BackToTop() {
        val breakpoint = rememberBreakpoint()
        var scroll : Double? by remember { mutableStateOf(null) }

        LaunchedEffect(Unit) {
                window.addEventListener(type = "scroll",callback = {
                        scroll = document.documentElement?.scrollTop
                })
        }
        Box(modifier = Modifier.fillMaxHeight()
                .fillMaxWidth(if(breakpoint > Breakpoint.LG) 65.percent else if (breakpoint > Breakpoint.MD) 80.percent  else  95.percent)
                .styleModifier {
                        property("pointer-events", "none")
                }

        ) {
                Column(
                        modifier = Modifier
                                .fillMaxSize()
                                .position(Position.Fixed)
                                .zIndex(1)
                                .styleModifier {
                                        property("pointer-events", "none")
                                },
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.End
                ) {
                        Box(
                                modifier = BackToTopStyle.toModifier()
                                        .size(if (breakpoint > Breakpoint.MD) 50.px else 30.px)
                                        .visibility(
                                                if (scroll != null && scroll!! > 400.0) Visibility.Visible
                                                else Visibility.Hidden
                                        )
                                        .borderRadius(if (breakpoint >= Breakpoint.MD) 30.px else 20.px)
                                        .margin(
                                                bottom = if (breakpoint > Breakpoint.MD) 40.px else 15.px,
                                                right = if (breakpoint > Breakpoint.MD) 40.px else 15.px
                                        )
                                        .backgroundColor(Theme.Primary.rgb)
                                        .opacity(0.5f)
                                        .cursor(Cursor.Pointer)
                                        .onClick { document.documentElement?.scroll(0.0, 0.0) }
                                        .styleModifier {
                                                property("pointer-events", "auto")
                                        },
                                contentAlignment = Alignment.Center
                        ) {
                                FaArrowUp(
                                        modifier = Modifier.color(Colors.White),
                                        size = if (breakpoint > Breakpoint.MD) IconSize.LG else IconSize.XS
                                )
                        }

                }
        }
}