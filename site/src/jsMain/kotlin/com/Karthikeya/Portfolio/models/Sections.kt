package com.Karthikeya.Portfolio.models

enum class Sections(
    val id : String,
    val title : String,
    val subtitle : String,
    val path : String
) {
    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home"
    ),
    About(
    id = "about",
    title = "About Me",
    subtitle = "My Introduction",
    path = "#about"
    ),
    Skills(
    id = "skills",
    title = "Skills",
    subtitle = "My Technical level",
    path = "#skills"
    ),
    Services(
        id = "services",
        title = "Services",
        subtitle = "What i offer",
        path = "#services"
    ),
    Qualifications
        (
        id = "qualifications",
        title = "Qualifications",
        subtitle = "My personal journey",
        path = "#qualifications"
    ),
    Projects
        (
        id = "projects",
        title = "My Projects",
        subtitle = "let's go",
        path = "#projects"
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subtitle = "Get in touch",
        path = "#contact"
    )
}