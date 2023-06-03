package com.Karthikeya.Portfolio.components

import androidx.compose.runtime.Composable
import com.Karthikeya.Portfolio.styles.SocialLinkIconLink
import com.Karthikeya.Portfolio.util.Constants.GIT_ID
import com.Karthikeya.Portfolio.util.Constants.INSTA_ID
import com.Karthikeya.Portfolio.util.Constants.LINKEDIN_ID
import com.Karthikeya.Portfolio.util.Constants.TWITTER_ID
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar() {
    val breakpoint = rememberBreakpoint()
    Box(modifier = Modifier.margin(right = if(breakpoint >=Breakpoint.MD)10.percent else 20.px , left = 0.px),
        contentAlignment = Alignment.CenterStart) {
        Column(
            modifier = Modifier
                .margin(left = 0.px)
                .maxWidth(50.px)
                .height(200.px)
                .padding(10.px)
                .borderRadius(20.px)
                .backgroundColor(Colors.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SocialLinks()
        }
    }

}

@Composable
fun FooterSocialBar() {
    Row (modifier = Modifier
        .maxWidth(50.px)
        .padding(10.px),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialLinks(1)
    }

}

@Composable
fun SocialLinks(footer : Int = 0 ) {
    Link(path = INSTA_ID,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB)
    {
        FaInstagram(size = IconSize.LG,
            modifier = SocialLinkIconLink.toModifier()
                .margin(right = if(footer == 1) 40.px else 0.px, bottom = 40.px))
    }
    Link(path = LINKEDIN_ID,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB)
    {
        FaLinkedin(size = IconSize.LG,
            modifier = SocialLinkIconLink.toModifier()
                .margin(right = if(footer == 1) 40.px else 0.px, bottom = 40.px))
    }
    Link(path = GIT_ID,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB)
    {
        FaSquareGithub(size = IconSize.LG,
            modifier = SocialLinkIconLink.toModifier()
                .margin(right = if(footer == 1) 40.px else 0.px, bottom = 40.px))
    }
    Link(path = TWITTER_ID,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB)
    {
        FaTwitter(size = IconSize.LG,
            modifier = SocialLinkIconLink.toModifier()
                .margin(bottom = if(footer == 1) 40.px else 0.px))
    }

}