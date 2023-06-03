package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.components.FooterSocialBar
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.NavigationItemStyle
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.Constants.MY_NAME
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top=100.px),
        contentAlignment = Alignment.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .backgroundColor(Colors.White)
        .height(350.px)) {
            Column ( modifier = Modifier.fillMaxWidth().margin(top = 20.px),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                P(
                    attrs = Modifier
                        .margin(top=20.px )
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(40.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text(value = MY_NAME)
                }
                Row(modifier = Modifier.fillMaxWidth()
                    .margin(topBottom = 20.px)
                    ,verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Link( modifier = NavigationItemStyle.toModifier()
                        .margin(right = 20.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.SemiBold)
                        .textDecorationLine(TextDecorationLine.None),
                        text = Sections.About.title,
                        path = Sections.About.path)
                    Link( modifier = NavigationItemStyle.toModifier()
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.SemiBold)
                        .textDecorationLine(TextDecorationLine.None),
                        text = Sections.Projects.title,
                        path = Sections.Projects.path)
                }
                FooterSocialBar()
                P(
                    attrs = Modifier
                        .margin(topBottom = 50.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(12.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text("All rights reserved")
                }
            }
    }
}