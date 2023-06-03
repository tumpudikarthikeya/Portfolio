package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.AboutMeCardData
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.AboutCardStyle
import com.Karthikeya.Portfolio.util.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutMeCard() {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        AboutMeCardData.values().forEach { card ->
            AboutMeItem(card)
        }
    }
}

@Composable
fun AboutMeItem(card: AboutMeCardData) {
    val breakpoint = rememberBreakpoint()
    Box(modifier = AboutCardStyle.toModifier()
        .backgroundColor(Colors.White)
        .margin(right = if(card.iconno != 3) 20.px else 0.px)
        .width(if(breakpoint >= Breakpoint.SM)120.px else 90.px)
        .height(if(breakpoint >= Breakpoint.SM)100.px else 80.px)
        .borderRadius(
            topRightAndBottomLeft = 20.px,
            topLeft = 20.px),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            if(card.iconno == 1){
                FaAward(
                    size = if(breakpoint >= Breakpoint.SM) IconSize.LG else IconSize.SM,
                    modifier = Modifier.margin(top=15.px)
                )
            }
            else if(card.iconno == 2){
                FaSuitcase(
                    size = if(breakpoint >= Breakpoint.SM) IconSize.LG else IconSize.SM,
                    modifier = Modifier.margin(top=15.px))
            }
            else{
                FaHeadset(
                    size = if(breakpoint >= Breakpoint.SM) IconSize.LG else IconSize.SM,
                    modifier = Modifier.margin(top=15.px)
                )
            }
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if(breakpoint >= Breakpoint.SM) 15.px else 10.px)
                    .margin(top = 10.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(card.title)
            }
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .margin(top = 0.px)
                    .fontSize(8.px)
                    .fontWeight(FontWeight.SemiBold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(card.desc)
            }
        }
    }
}
