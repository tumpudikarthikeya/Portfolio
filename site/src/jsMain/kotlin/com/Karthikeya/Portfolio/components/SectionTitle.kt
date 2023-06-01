package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.util.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    title : String,
    subTitle : String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        P(
            attrs = Modifier
                .margin(bottom = 4.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(30.px)
                .fontWeight(FontWeight.Bolder)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text(title)
        }
        P(
            attrs = Modifier
                .margin(bottom = 5.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.DarkGray.rgb)
                .toAttrs()
        ) {
            Text(value = subTitle)
        }
    }
}