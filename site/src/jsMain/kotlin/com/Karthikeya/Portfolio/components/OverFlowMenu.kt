package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.*
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.MyNameStyle
import com.Karthikeya.Portfolio.styles.NavigationItemStyle
import com.Karthikeya.Portfolio.util.Constants
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaXRay
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun OverFlowMenu(onMenuClosed : () -> Unit){
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    LaunchedEffect(breakpoint){
        translateX = 0.percent
        opacity = 100.percent
        if(breakpoint > Breakpoint.MD){
            translateX = (-100).percent
            opacity =0.percent
            delay(500)
            onMenuClosed()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            . backgroundColor(argb(0.5f,0.0f,0.0f,0.0f))
            .transition(CSSTransition(property = "opacity", duration = 300.ms))
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(all = 25.px)
            .width(if(breakpoint< Breakpoint.MD)50.percent else 25.percent)
            . overflow(Overflow.Auto)
            . scrollBehavior(ScrollBehavior. Smooth)
            . backgroundColor (Colors. White)
            . translateX(tx = translateX)
            . transition(CSSTransition(property = "translateX", duration = 500.ms))
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(bottom = 25.px)) {
                P(
                    attrs = MyNameStyle.toModifier()
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text(value = Constants.MY_NAME)
                }
                FaXmark(modifier = Modifier
                    .cursor(Cursor.Pointer)
                    .onClick {
                        scope.launch {
                            translateX = (-100).percent
                            opacity = 0.percent
                            onMenuClosed()
                        }
                    },
                    size = IconSize.LG
                )

            }
            Sections.values().forEach { section ->
                Link( modifier = NavigationItemStyle.toModifier()
                    .margin(bottom = 10.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(15.px)
                    .fontWeight(FontWeight.SemiBold)
                    .textDecorationLine(TextDecorationLine.None)
                    .onClick {
                             scope.launch {
                                 translateX = (-100).percent
                                 opacity = 0.percent
                                 onMenuClosed()
                             }
                    },
                    text = section.title,
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    path = section.path)
            }
        }

    }

}