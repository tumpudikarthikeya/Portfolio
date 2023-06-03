package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.components.SectionTitle
import com.Karthikeya.Portfolio.components.SkillCards
import com.Karthikeya.Portfolio.models.Sections
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun SkillsSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxWidth(if(breakpoint > Breakpoint.MD) 65.percent else 90.percent)
            .id("skills")
            .padding(topBottom = 100.px)
        ,contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SectionTitle(Sections.Skills)
            SkillCards()
        }
    }


}
