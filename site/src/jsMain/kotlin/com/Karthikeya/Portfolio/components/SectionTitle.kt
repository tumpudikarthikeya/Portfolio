package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(section : Sections , modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    var titlemargin by remember { mutableStateOf(50.px) }
    var subtitlemargin by remember { mutableStateOf(50.px) }

    ObserveViewPortEntered(
        sectionld = section.id,
        distanceFromTop = 700.0,
        onViewportEntered = {
            scope.launch {
                subtitlemargin = 0.px
                //delay(25)
                titlemargin =0.px
            }
        }

    )

    Column(  modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        P(
            attrs = Modifier
                .margin(bottom = 4.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(30.px)
                .fontWeight(FontWeight.Bolder)
                .color(Theme.Primary.rgb)
                //.id(section.id)
                .margin(left = titlemargin , top = 0.px,bottom = 0.px)
                .toAttrs()
        ) {
            Text(section.title)
        }
        P(
            attrs = Modifier
                .margin(bottom = 5.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.DarkGray.rgb)
                .margin(
                    left = 0.px,
                    right = subtitlemargin,
                    bottom = 10.px,
                    top = 0.px
                )
                .transition(CSSTransition(property = "margin", duration = 500.ms))
                .toAttrs()
        ) {
            Text(value = section.subtitle)
        }
    }
}