package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.components.AboutMeCard
import com.Karthikeya.Portfolio.components.SectionTitle
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.MainButtonStyle
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.Constants.ABOUT_ME
import com.Karthikeya.Portfolio.util.Res.Imaage.Intro_Image
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
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
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaDownload
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutMeSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxWidth(if(breakpoint > Breakpoint.MD) 65.percent else 90.percent)
            .id("about")
            .margin(top=200.px),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SectionTitle(Sections.About.title, Sections.About.subtitle)
            AboutMeContent(breakpoint)
        }
    }


}

@Composable
fun AboutMeContent(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.margin(top=30.px),verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleGrid(numColumns = numColumns(base = 1, md = 2)) {
            AboutImage(breakpoint)
            AboutText()
        }
    }
}

@Composable
fun AboutImage(breakpoint: Breakpoint) {
    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Image(
            src = Intro_Image,
            modifier = Modifier
                .borderRadius(
                    topRightAndBottomLeft = 100.px,
                    topLeft = 100.px
                )
                .size(350.px)
                .margin(leftRight = if (breakpoint >= Breakpoint.MD) 50.px else 0.px)
        )
    }
}

@Composable
fun AboutText() {
    Column(modifier = Modifier.fillMaxSize()
        .margin(top=40.px),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        AboutMeCard()
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .margin(topBottom = 30.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.DarkGray.rgb)
                .toAttrs()
        ) {
            Text(value = ABOUT_ME)
        }
        Button(attrs = MainButtonStyle.toModifier()
            .height(55.px)
            .border(width = 0.px)
            .borderRadius(r =10.px)
            .backgroundColor(Theme.Primary.rgb)
            .color(Colors.White)
            .cursor(Cursor.Pointer)
            .toAttrs()) {
            Link(path = Sections.Contact.path, text = "Download CV",
                modifier = Modifier.textDecorationLine(TextDecorationLine.None)
                    .color(Colors.White)
                    .fontSize(FontSize.Medium)
                    .margin(right = 10.px))
            FaDownload(size = IconSize.LG)
        }
    }
}