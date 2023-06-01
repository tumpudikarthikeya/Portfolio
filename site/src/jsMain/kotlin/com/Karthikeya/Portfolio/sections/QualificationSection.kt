package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.Karthikeya.Portfolio.components.EduTimeLine
import com.Karthikeya.Portfolio.components.ExpTimeLine
import com.Karthikeya.Portfolio.components.SectionTitle
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.util.Constants
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun QualificationSection() {
    val breakpoint = rememberBreakpoint()
    val switchTab = remember { mutableStateOf("education") }
    Box(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 90.percent)
            .margin(top=100.px)
            .id("qualifications"),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SectionTitle(Sections.Qualifications.title, Sections.Qualifications.subtitle)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//navicons
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.margin(35.px)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .margin(right = 20.px)
                            .color(if (switchTab.value == "education") Theme.DarkBlack.rgb else Theme.DarkGray.rgb)
                            .cursor(Cursor.Pointer)
                    ) {
                        FaGraduationCap(size = IconSize.LG)
                        P(
                            attrs = Modifier
                                .onClick {
                                    switchTab.value = "education"
                                }
                                .margin(left = 4.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Bold)
                                .toAttrs()
                        ) {
                            Text("Education")
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .color(if (switchTab.value == "experience") Theme.DarkBlack.rgb else Theme.DarkGray.rgb)
                            .cursor(Cursor.Pointer)
                    ) {
                        FaSuitcase(size = IconSize.LG)
                        P(
                            attrs = Modifier
                                .onClick {
                                    switchTab.value = "experience"
                                }
                                .margin(left = 4.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Bold)
                                .toAttrs()
                        ) {
                            Text("Experience")
                        }

                    }
                }
//nav
                if (switchTab.value == "education") {
                        EduTimeLine()
                    }
                else {
                        ExpTimeLine()
                    }
                }
        }
    }

}
