package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.ServiceMDCardStyle
import com.Karthikeya.Portfolio.styles.ServiceSMCardStyle
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.Res.Imaage.rightArrow
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(breakpoint: Breakpoint) {
    Box(modifier = Modifier.fillMaxSize().padding(10.px).margin(35.px),
        contentAlignment = Alignment.Center) {
        SimpleGrid(numColumns(base = 1, md = 3)) {
            Box(
                modifier = if (breakpoint >= Breakpoint.MD) { ServiceMDCardStyle.toModifier() } else { ServiceSMCardStyle.toModifier() }
                    .margin(10.px)
                    .padding(40.px)
                    .borderRadius(
                        topLeft = 50.px,
                        topRight = 50.px,
                        bottomRight = 0.px,
                        bottomLeft = 50.px
                    ), contentAlignment = Alignment.Center
            ) {
                CardData(1, "Web Development")
            }
            Box(
                modifier = if (breakpoint >= Breakpoint.MD){ ServiceMDCardStyle.toModifier()} else {ServiceSMCardStyle.toModifier() }
                    .margin(10.px)
                    .padding(40.px)
                    .borderRadius(
                        topLeft = 50.px,
                        topRight = 50.px,
                    ), contentAlignment = Alignment.Center
            ) {
                CardData(2, "Android Development")
            }
            Box(
                modifier = if (breakpoint >= Breakpoint.MD){ ServiceMDCardStyle.toModifier()} else {ServiceSMCardStyle.toModifier()}
                    .margin(10.px)
                    .padding(40.px)
                    .borderRadius(
                        topLeft = 50.px,
                        topRight = 50.px,
                        bottomRight = 50.px,
                        bottomLeft = 0.px
                    ), contentAlignment = Alignment.Center
            ) {
                CardData(3, "Machine Learning")
            }
        }
    }
}

@Composable
fun CardData(icon : Int, title :String) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        if (icon ==1) {
            FaDesktop(size = IconSize.LG, modifier = Modifier.margin(20.px))
        }
        else if (icon ==2){
            FaAndroid(size = IconSize.LG, modifier = Modifier.margin(20.px))
        }
        else {
            FaRobot(size = IconSize.LG, modifier = Modifier.margin(20.px))
        }
        P(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .textAlign(TextAlign.Center)
                .margin(bottom = 0.px)
                .fontWeight(FontWeight.Bold)
                .id("skillname")
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(title)
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.cursor(Cursor.Pointer)) {
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .textAlign(TextAlign.Center)
                    .margin(top = 4.px, right = 4.px)
                    .fontSize(10.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.DarkGray.rgb)
                    .toAttrs()
            ) {
                Text("View More")
            }
            Image(src = rightArrow, modifier = Modifier.size(10.px).margin(top = 4.px))
        }
    }
}