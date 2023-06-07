package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.MyNameStyle
import com.Karthikeya.Portfolio.styles.NavigationItemStyle
import com.Karthikeya.Portfolio.util.Constants.FONT_FAMILY
import com.Karthikeya.Portfolio.util.Constants.MY_NAME
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Header(onMenuClicked:() -> Unit) {
    val breakpoint = rememberBreakpoint()

    Row( modifier = Modifier
        .position(Position.Fixed)
        .fillMaxWidth(if(breakpoint > Breakpoint.LG) 65.percent else if (breakpoint > Breakpoint.MD) 80.percent  else  95.percent)
        .margin(bottom = 10.px)
        .padding(20.px)
        .borderRadius(20.px)
        .zIndex(1)
        .backgroundColor(Colors.White),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically)
    {
        LeftSide(onMenuClicked = onMenuClicked)
        RightSide()
    }

}

@Composable
fun LeftSide(
             onMenuClicked :() -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        //if (breakpoint <= Breakpoint.SM){
            FaBars(size = IconSize.LG,
                modifier = Modifier
                    .displayUntil(Breakpoint.MD)
                    .margin(right = 10.px)
                    .onClick { onMenuClicked() })
        //}
        P(
            attrs = MyNameStyle.toModifier()
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(20.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text(value = MY_NAME)
        }
    }
}

@Composable
fun RightSide() {
    Row (modifier = Modifier
        .displayIf(Breakpoint.MD)
        .fillMaxWidth().gap(30.px),
        horizontalArrangement = Arrangement.End) {

        Sections.values().forEach { section ->
            Link( modifier = NavigationItemStyle.toModifier()
                .fontFamily(FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.SemiBold)
                .textDecorationLine(TextDecorationLine.None),
                text = section.name,
                path = section.path)
        }

    }

}