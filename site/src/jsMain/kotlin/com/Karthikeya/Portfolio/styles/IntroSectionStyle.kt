package com.Karthikeya.Portfolio.styles

import com.Karthikeya.Portfolio.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val SocialLinkIconLink by ComponentStyle {
    base {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Theme.Primary.rgb)
    }
}

val IntroImageStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Theme.Primary.rgb)
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier
            .width(150.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier
            .width(170.px)
    }
}