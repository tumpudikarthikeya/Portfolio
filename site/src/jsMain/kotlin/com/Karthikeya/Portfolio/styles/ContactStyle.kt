package com.Karthikeya.Portfolio.styles

import com.Karthikeya.Portfolio.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderColor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms

val InputBoxStyle by ComponentStyle {
    base {
        Modifier
            .borderColor(Theme.Gray.rgb)
            .transition(CSSTransition(property = "borderColor", duration = 200.ms))
    }
    hover {
        Modifier
            .borderColor(Theme.Primary.rgb)
    }
}