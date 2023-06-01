package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.ProjectData
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.ProjectSectionStyle
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.Res.Imaage.ExternalLink
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project : ProjectData,
    link : String
) {
    Box(modifier = modifier
        .maxWidth(300.px)
        .fillMaxSize()
        .margin(20.px)
        , contentAlignment = Alignment.Center) {
        Link(
            modifier = ProjectSectionStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None)
            .fillMaxWidth(),
            path = link,
            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().id("columnParent")
            ) {
                Box(
                    modifier = Modifier
                        .id("boxParent")
                        .fillMaxWidth()
                        .maxWidth(300.px)
                        .margin(bottom = 20.px)
                ) {
                    Image(
                        modifier = Modifier
                            .size(300.px)
                            .objectFit(ObjectFit.Cover),
                        src = project.image,
                        desc = "project image"
                    )
                    Box(
                        modifier = Modifier.id("greenOverlay")
                            .fillMaxHeight()
                            .backgroundColor(argb(a = 0.5f, r = 0, g = 167, b = 142)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            src = ExternalLink, modifier = Modifier
                                .id("linkIcon")
                                .size(25.px)
                        )
                    }
                }
                P(
                    attrs = Modifier
                        .fillMaxWidth()
                        .margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.DarkBlack.rgb)
                        .toAttrs()
                ) {
                    Text(project.title)
                }
                P(
                    attrs = Modifier
                        .fillMaxWidth()
                        .margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .opacity(50.percent)
                        .toAttrs()
                ) {
                    Text(project.desc)
                }
            }
        }
    }
}