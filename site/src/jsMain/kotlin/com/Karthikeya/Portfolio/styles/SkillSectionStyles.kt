package com.Karthikeya.Portfolio.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.rgba


val SkillCardStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Colors.White)
            .transition(CSSTransition(property = "backgroundColor", duration = 200.ms))
    }
    hover {
        Modifier
            .backgroundColor(rgba(r =0 , g = 167, b =142 , a=0.5f))
    }

}

