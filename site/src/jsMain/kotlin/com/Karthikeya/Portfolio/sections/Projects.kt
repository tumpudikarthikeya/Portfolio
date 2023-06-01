package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.components.ProjectCard
import com.Karthikeya.Portfolio.components.SectionTitle
import com.Karthikeya.Portfolio.models.ProjectData
import com.Karthikeya.Portfolio.models.Sections
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectsSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth(90.percent)
            .margin(top=100.px),
        contentAlignment = Alignment.Center
    ) {
        ProjectContent()
    }

}

@Composable
fun ProjectContent(){
    Column(modifier = Modifier
        .fillMaxWidth().id("projects"),
        horizontalAlignment = Alignment.CenterHorizontally) {
        SectionTitle(title = Sections.Projects.title, subTitle = Sections.Projects.subtitle)
        ProjectCards()
    }
}

@Composable
fun ProjectCards() {
    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleGrid(numColumns( base = 1, sm = 1, md = 2)) {
        ProjectData.values().forEach { project ->
            ProjectCard(modifier = Modifier.margin(40.px), project, "")
        }
    }
 }
}

