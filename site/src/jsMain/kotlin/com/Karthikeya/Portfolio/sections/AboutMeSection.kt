package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.rememberCoroutineScope
import com.Karthikeya.Portfolio.components.AboutMeCard
import com.Karthikeya.Portfolio.components.SectionTitle
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.MainButtonStyle
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.Constants.ABOUT_ME
import com.Karthikeya.Portfolio.util.Res.Imaage.Intro_Image
import com.Karthikeya.Portfolio.util.Res.Imaage.fileDownload
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.file.saveToDisk
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.get
import org.w3c.files.File

@Composable
fun AboutMeSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxWidth(if(breakpoint > Breakpoint.LG) 65.percent else if (breakpoint > Breakpoint.MD) 80.percent  else  95.percent)
            .padding(topBottom = 100.px).id("about")
        ,contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SectionTitle(Sections.About)
            AboutMeContent(breakpoint)
        }
    }


}

@Composable
fun AboutMeContent(breakpoint: Breakpoint) {
    Column(

        verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleGrid(numColumns = numColumns(base = 1, md = 2)) {
            AboutImage(breakpoint)
            AboutText(breakpoint)
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
                .size(if(breakpoint >= Breakpoint.SM)350.px else 250.px)
                .margin(leftRight = if (breakpoint >= Breakpoint.MD) 50.px else 0.px)
        )
    }
}

@Composable
fun AboutText(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.fillMaxSize()
            .margin(top = 40.px),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AboutMeCard()
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .margin(topBottom = 30.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.SM) 16.px else 15.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.DarkGray.rgb)
                .toAttrs()
        ) {
            Text(value = ABOUT_ME)
        }
            val scope = rememberCoroutineScope()
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(60.px)
                    .id("Resume")
                    .border(width = 0.px)
                    .onClick {scope.launch {
                        document.saveToDisk("Resume", window.http.get("/resume.pdf"),"application/pdf")
                    }
                    }
                    .borderRadius(r = 20.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    P( attrs = Modifier.textDecorationLine(TextDecorationLine.None)
                        .color(Colors.White)
                        .fontSize(FontSize.Medium)
                        .margin(right = 10.px).toAttrs() ) {
                        Text(value = "Download CV")
                    }
                    Image(fileDownload)
                }
        }
    }
}
