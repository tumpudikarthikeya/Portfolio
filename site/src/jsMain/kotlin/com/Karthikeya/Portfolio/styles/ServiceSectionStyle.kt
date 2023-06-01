package com.Karthikeya.Portfolio.styles

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@OptIn(ExperimentalComposeWebApi::class)
val ServiceMDCardStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Colors.White)
            .transition(CSSTransition(property ="backgroundColor", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(rgba(r =0 , g = 167, b =142 , a=0.5f))
            .transform {translateY(ty = (-20).px)
            }
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val ServiceSMCardStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Colors.White)
            .transition(CSSTransition(property ="backgroundColor", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(rgba(r =0 , g = 167, b =142 , a=0.5f))
            .margin(bottom = 0.px)
            .transform {translateX(tx = (20).px)
            }
    }
}