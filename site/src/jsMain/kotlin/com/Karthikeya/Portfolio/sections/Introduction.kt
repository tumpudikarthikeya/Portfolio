package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.components.SocialBar
import com.Karthikeya.Portfolio.components.animateImage
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
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
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
            .fillMaxWidth(if(breakpoint > Breakpoint.LG) 65.percent else if (breakpoint > Breakpoint.MD) 80.percent  else  95.percent)
            .padding(top=200.px , bottom = 100.px)
            .id("home")
    ) {
        IntroContent(breakpoint)
    }

}

@Composable
fun IntroContent(breakpoint: Breakpoint){

            if (breakpoint >= Breakpoint.MD) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.gap(24.px)
                        .fillMaxWidth()) {
                    SocialBar()
                    IntroText(breakpoint)
                    IntroImage(breakpoint)
                }
            } else {
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.gap(24.px).fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.gap(24.px).fillMaxWidth()) {
                        SocialBar()
                        IntroImage(breakpoint)
                    }
                    IntroText(breakpoint)
                }
            }
        }



@Composable
fun IntroImage(breakpoint: Breakpoint){

           Image(
                src = Intro_Image,
                modifier = animateImage.toModifier()
                    .size(if(breakpoint > Breakpoint.LG) 300.px else if(breakpoint >= Breakpoint.MD) 250.px else 200.px)
            )

}

@Composable
fun IntroText(breakpoint: Breakpoint) {

            Column(
                modifier = Modifier
                .fillMaxWidth()
            ) {
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(if (breakpoint >= Breakpoint.MD) 50.px else 40.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text(value = MY_NAME)
                }
                Image(
                    src = HI, desc = "Hi",
                    modifier = Modifier.margin(topBottom = 20.px)
                )
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
                        .fontSize(if (breakpoint >= Breakpoint.MD) 16.px else 15.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.DarkGray.rgb)
                        .toAttrs()
                ) {
                    Text(value = INTRO)
                }
                Button(
                    attrs = MainButtonStyle.toModifier()
                        .margin(top = 30.px)
                        .height(55.px)
                        .border(width = 0.px)
                        .borderRadius(r = 10.px)
                        .backgroundColor(Theme.Primary.rgb)
                        .color(Colors.White)
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    Link(
                        path = Sections.Contact.path, text = "Say Hello",
                        modifier = Modifier.textDecorationLine(TextDecorationLine.None)
                            .color(Colors.White)
                            .fontSize(FontSize.Medium)
                            .margin(right = 10.px)
                    )
                    Image(src = Res.Imaage.send, modifier = Modifier.size(20.px))
                }
            }

}