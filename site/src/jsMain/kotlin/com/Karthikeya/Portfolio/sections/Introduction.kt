package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.components.SocialBar
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.MainButtonStyle
import com.Karthikeya.Portfolio.util.Constants.FONT_FAMILY
import com.Karthikeya.Portfolio.util.Constants.INTRO
import com.Karthikeya.Portfolio.util.Constants.INTRO_TITLE
import com.Karthikeya.Portfolio.util.Constants.MY_NAME
import com.Karthikeya.Portfolio.util.Res
import com.Karthikeya.Portfolio.util.Res.Imaage.HI
import com.Karthikeya.Portfolio.util.Res.Imaage.Intro_Image
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaPaperPlane
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun IntroSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxWidth(if(breakpoint > Breakpoint.MD) 65.percent else 90.percent)
            .margin(top=200.px)
            .id("home"),
        contentAlignment = Alignment.Center
    ) {
        IntroContent(breakpoint)
    }

}

@Composable
fun IntroContent(breakpoint: Breakpoint){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()) {
            SimpleGrid(numColumns = numColumns(base = 1 , md = 2)) {
                if(breakpoint >= Breakpoint.MD) {
                    IntroText(breakpoint , 100)
                    IntroImage(breakpoint)
                }
                else {
                    IntroImage(breakpoint)
                    IntroText(breakpoint)
                }
            }

        }
    }

@Composable
fun IntroImage(breakpoint: Breakpoint){
    Row(verticalAlignment = Alignment.CenterVertically) {
        if(breakpoint <= Breakpoint.SM) {
            SocialBar()
        }
        Image(
            src = Intro_Image,
            modifier = Modifier
                .border(
                    width = 8.px,
                    color = rgba(r = 0, g = 167, b = 142, a = 0.45f),
                    style = LineStyle.Solid
                )
                .borderRadius(r=10.px)
                .width(250.px)
                .height(250.px)
                .margin(left = 50.px)
        )
    }
}

@Composable
fun IntroText(breakpoint: Breakpoint, leftMargin : Int = 0) {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        if (breakpoint > Breakpoint.SM) {
            SocialBar()
        }
        Column(
            modifier = Modifier
                .minWidth(380.px)
                .margin(right = 100.px , left = leftMargin.px)
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 50.px else 40.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(value = MY_NAME)
            }
            Image(src = HI, desc = "Hi", modifier = Modifier.margin(topBottom = 20.px))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Box(
                    modifier = Modifier
                        .height(1.px)
                        .width(70.px)
                        .margin(right = 10.px)
                        .backgroundColor(Theme.Gray.rgb)
                )
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text(value = INTRO_TITLE)
                }
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.DarkGray.rgb)
                    .toAttrs()
            ) {
                Text(value =INTRO)
            }
            Button(attrs = MainButtonStyle.toModifier()
                .margin(top= 30.px)
                .height(55.px)
                .border(width = 0.px)
                .borderRadius(r =10.px)
                .backgroundColor(Theme.Primary.rgb)
                .color(Colors.White)
                .cursor(Cursor.Pointer)
                .toAttrs()) {
                Link(path = Sections.Contact.path, text = "Say Hello",
                    modifier = Modifier.textDecorationLine(TextDecorationLine.None)
                        .color(Colors.White)
                        .fontSize(FontSize.Medium)
                        .margin(right = 10.px))
                Image(src = Res.Imaage.send, modifier = Modifier.size(20.px))
            }
        }
    }
}