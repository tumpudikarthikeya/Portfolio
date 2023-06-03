package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.InputBoxStyle
import com.Karthikeya.Portfolio.styles.MainButtonStyle
import com.Karthikeya.Portfolio.util.Res.Imaage.send
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun Contactform() {
    Box(contentAlignment = Alignment.Center) {
        Form(
            action = "https://formspree.io/f/myyaardz",
            attrs = Modifier
                .attrsModifier {
                    attr("method", "POST")
                }
                .toAttrs()
        ) {
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs() ,
                forId = "inputName"
            ) {
                Text("Name")
            }
            Input(type = InputType.Text,
                attrs = InputBoxStyle.toModifier()
                    .id("inputName")
                    .classNames("form-control")
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .margin(bottom = 20.px)
                    .width(300.px)
                    .backgroundColor(Theme.LighterGray.rgb)
                    .attrsModifier {
                        attr("placeholder", "Full Name")
                        attr("name", "name")
                        attr("required", "true")
                    }
                    .toAttrs()
            )
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs() ,
                forId = "inputEmail"
            ) {
                Text("Email")
            }
            Input(type = InputType.Email,
                attrs = InputBoxStyle.toModifier()
                    .id("inputEmail")
                    .classNames("form-control")
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .margin(bottom = 20.px)
                    .width(300.px)
                    .backgroundColor(Theme.LighterGray.rgb)
                    .attrsModifier {
                        attr("placeholder", "Email Address")
                        attr("name", "email")
                        attr("required", "true")
                    }
                    .toAttrs()
            )
            Label(
                attrs = Modifier
                    .classNames("form-label")
                    .toAttrs(),
                forId = "inputMessage"
            ) {
                Text("Message")
            }
            TextArea(
                attrs = InputBoxStyle.toModifier()
                    .id("inputMessage")
                    .classNames("form-control")
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .margin(bottom = 30.px)
                    .height(150.px)
                    .width(300.px)
                    .backgroundColor(Theme.LighterGray.rgb)
                    .attrsModifier {
                        attr("placeholder", "Your Message")
                        attr("name", "message")
                        attr("required", "true")
                    }
                    .toAttrs()
            )
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(60.px)
                    .border(width = 0.px)
                    .borderRadius(20.px)
                    .padding(10.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Text("Send Message")
                Image(src = send , modifier = Modifier.margin(left = 5.px).size(20.px))
            }
        }
    }
}