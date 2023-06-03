package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.QualificationData
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.util.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.*
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun QualificationText(data: QualificationData , align : Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.Start) {
        Row( modifier = Modifier.width(200.px),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (align == 1) {
                FaCircle(style = IconStyle.FILLED, size = IconSize.X1, modifier = Modifier.color(Theme.Primary.rgb))
            }
            Column(horizontalAlignment = Alignment.Start) {
                P(
                    attrs = Modifier
                        .margin(bottom = 4.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.DarkBlack.rgb)
                        .toAttrs()
                ) {
                    Text(data.title)
                }


                P(
                    attrs = Modifier
                        .margin(bottom = 4.px, top = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .maxWidth(150.px)
                        .fontSize(12.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.DarkGray.rgb)
                        .toAttrs()
                ) {
                    Text(data.subTitle)
                }
                Row(
                    modifier = Modifier.margin(top = 0.px), verticalAlignment = Alignment.CenterVertically
                ) {
                    FaCalendar(
                        size = IconSize.X1,
                        modifier = Modifier.color(Theme.Primary.rgb).margin(right = 2.px)
                    )
                    P(
                        attrs = Modifier
                            .margin(0.px)
                            .fontFamily(Constants.FONT_FAMILY)
                            .fontSize(12.px)
                            .fontWeight(FontWeight.Normal)
                            .color(Theme.DarkGray.rgb)
                            .toAttrs()
                    ) {
                        Text(data.year)
                    }
                }
            }
            if (align == 2) {
                FaCircle(style = IconStyle.FILLED, size = IconSize.X1, modifier = Modifier.color(Theme.Primary.rgb))
            }

        }

    }
}
@Composable
fun EduTimeLine() {
    Box(modifier = Modifier.margin(10.px).id("education")) {
        Row {
            Column(modifier = Modifier.margin(right = ((-8.5).px))) {
                QualificationData.values().take(3).forEachIndexed { index, qualification ->
                    if (index%2==0){
                        QualificationText(qualification,2, Modifier.margin(bottom = 100.px))
                    }
                }
            }
            Box {
                Box (modifier = Modifier
                    .backgroundColor(Theme.Primary.rgb)
                    .width((1.5).px)
                    .height(300.px)
                    )
            }
            Column(modifier = Modifier.margin(left = ((-8.5).px))) {
                QualificationData.values().take(3).forEachIndexed { index, qualification ->
                    if (index%2 != 0){
                        QualificationText(qualification,1, Modifier.margin(top = 100.px))
                    }
                }
            }
        }
    }
}

@Composable
fun ExpTimeLine() {
    Box(modifier = Modifier.margin(10.px).id("education")) {
        Row {
            Column(modifier = Modifier.margin(right = ((-8.5).px))) {
                QualificationData.values().slice(3..5).forEachIndexed { index, qualification ->
                    if (index%2==0){
                        QualificationText(qualification,2, Modifier.margin(bottom = 100.px))
                    }
                }
            }
            Box {
                Box (modifier = Modifier
                    .backgroundColor(Theme.Primary.rgb)
                    .width((1.5).px)
                    .height(300.px)
                )
            }
            Column(modifier = Modifier.margin(left = ((-8.5).px))) {
                QualificationData.values().slice(3..5).forEachIndexed { index, qualification ->
                    if (index%2 != 0){
                        QualificationText(qualification,1, Modifier.margin(top = 100.px))
                    }
                }
            }
        }
    }
}

