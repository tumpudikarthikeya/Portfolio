package com.Karthikeya.Portfolio.pages

import androidx.compose.runtime.*
import com.Karthikeya.Portfolio.components.*
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page


@Page
@Composable
fun HomePage() {

    var menuOpend by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
    Column(
        modifier = Modifier.fillMaxSize()
            .backgroundColor(Theme.LighterGray.rgb),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(onMenuClicked ={ menuOpend = true} )
        IntroSection()
        AboutMeSection()
        SkillsSection()
        ServiceSection()
        QualificationSection()
        ProjectsSection()
        ContactSection()
        FooterSection()
    }
        BackToTop()
        if (menuOpend){
            OverFlowMenu(onMenuClosed = { menuOpend = false })
        }
 }
}
