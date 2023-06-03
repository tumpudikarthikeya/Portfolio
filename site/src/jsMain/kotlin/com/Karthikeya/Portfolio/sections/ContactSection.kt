package com.Karthikeya.Portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import com.Karthikeya.Portfolio.components.Contactform
import com.Karthikeya.Portfolio.components.SectionTitle
import com.Karthikeya.Portfolio.models.Sections
import com.Karthikeya.Portfolio.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun ContactSection() {
    val scope = rememberCoroutineScope()
    var animatedAngle by remember { mutableStateOf(0.deg) }
    val breakpoint = rememberBreakpoint()
    ObserveViewPortEntered(
        sectionld = Sections.Contact.id,
        distanceFromTop = 500.0 ,
        onViewportEntered = {
            animatedAngle = 10.deg
            scope.launch {
                delay(500)
                animatedAngle =0.deg
            }
        }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth(if(breakpoint > Breakpoint.MD) 65.percent else 90.percent)
            .padding(topBottom = 100.px)
            .id("contact")
        ,contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SectionTitle(Sections.Contact,
                Modifier
                    //.margin(top = 100.px)
                    .transform { rotate(animatedAngle) }
                    .transition(CSSTransition(property = "transform" , duration = 500.ms)))
            Contactform()
        }
    }


}