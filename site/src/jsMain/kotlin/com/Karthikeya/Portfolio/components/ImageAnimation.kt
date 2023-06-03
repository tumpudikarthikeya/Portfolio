@file:Suppress("DEPRECATION")

package com.Karthikeya.Portfolio.components


import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.CSSAnimation
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.animation.keyframes
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.JustifyContent



val animateImage by ComponentStyle {
    base {
        Modifier
            .background(CSSBackground(
                repeat = BackgroundRepeat.NoRepeat,
                position = BackgroundPosition.Center,
                size = BackgroundSize.Cover))
            .alignContent(AlignContent.Center)
            .justifyContent(JustifyContent.Center)
            .boxShadow(0.px, 0.px, 0.px, 9.px, rgba(r =0 , g = 167, b =142 , a= 0.5f))
            .order(1)
            .animation(
                CSSAnimation(
                    name = "profile_animation",
                    duration = 8.s,
                    delay = 1.s,
                    timingFunction = AnimationTimingFunction.EaseInOut,
                    iterationCount = AnimationIterationCount.Infinite,
                    direction = AnimationDirection.Normal,
                    fillMode = AnimationFillMode.None,
                    playState = AnimationPlayState.Running
                )
            )
    }
}

val profile_animation by keyframes {
    0.percent {
        Modifier.styleModifier {
            property("border-radius" , "60% 40% 30% 70%/60% 30% 70% 40%")
        }
    }
    59.percent {
        Modifier.styleModifier {
            property("border-radius" , "30% 60% 70% 40%/50% 60% 30%")
        }
    }
    to {
        Modifier.styleModifier {
            property("border-radius" , "60% 40% 30% 70%/60% 30% 70% 40%")
        }
    }
}