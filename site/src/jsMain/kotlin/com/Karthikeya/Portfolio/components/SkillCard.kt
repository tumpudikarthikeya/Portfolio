package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.models.SkillModel
import com.Karthikeya.Portfolio.models.Theme
import com.Karthikeya.Portfolio.styles.SkillCardStyle
import com.Karthikeya.Portfolio.util.Constants
import com.Karthikeya.Portfolio.util.Constants.rate
import com.Karthikeya.Portfolio.util.Constants.temp
import com.Karthikeya.Portfolio.util.Res.Imaage.badge
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillCards() {
    Box(modifier = Modifier.fillMaxWidth()
        .margin(top= 30.px),
        contentAlignment = Alignment.Center) {
        SimpleGrid(numColumns(base = 1, md = 2)) {
            SkillModel.values().forEach {
                SkillCard(it)
                temp += 1
            }
        }
    }
}


@Composable
fun SkillCard(skill: SkillModel) {
    Box(modifier = SkillCardStyle.toModifier()
        .borderRadius(
            topLeft = if(temp==4) 0.px else 50.px ,
            topRight = if(temp==3) 0.px else 50.px,
            bottomRight = if(temp == 1) 0.px else 50.px ,
            bottomLeft = if(temp==2) 0.px else 50.px
        )
        .padding(20.px)
        .margin(20.px),
        contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Domain(skill.skillData.domain)
            SimpleGrid(numColumns(base = 1 , sm = 2), modifier = Modifier.fillMaxSize()) {
            skill.skillData.skills.forEach {
                        SkillItem(it, 0)
                }
            }
        }
    }
}

@Composable
fun Domain(domain : String) {
    P(
        attrs = Modifier
            .fontFamily(Constants.FONT_FAMILY)
            .fontSize(13.px)
            .fontWeight(FontWeight.Bolder)
            //.color(Theme.Primary.rgb)
            .toAttrs()
    ) {
        Text(domain)
    }
}
@Composable
fun SkillItem(skill : String , rating : Int) {
    val  breakpoint = rememberBreakpoint()
    Row(modifier = Modifier.fillMaxSize()
        .padding(10.px)
        , verticalAlignment = Alignment.Top) {
        Image(src = badge , modifier = Modifier.size(if(breakpoint> Breakpoint.SM)20.px else 15.px))
        Column(modifier = Modifier.fillMaxSize()
            .padding(5.px),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top) {
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if(breakpoint> Breakpoint.SM)16.px else 11.px)
                    .margin(bottom = 0.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(skill)
            }
            P(
                attrs = Modifier
                    .margin(top = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .margin(top = 4.px)
                    .fontSize(if(breakpoint> Breakpoint.SM)15.px else 10.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.DarkGray.rgb)
                    .toAttrs()
            ) {
                Text("${rate[rating]}")
            }
        }
    }
}