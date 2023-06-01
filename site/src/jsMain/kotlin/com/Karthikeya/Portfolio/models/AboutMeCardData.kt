package com.Karthikeya.Portfolio.models


enum class AboutMeCardData(
    val iconno : Int,
    val title : String,
    val desc : String
) {
    Experience(
        iconno = 1,
        title = "Experience",
        desc = "1 Years Working"
    ),
    Projects(
        iconno = 2,
        title = "Completed",
        desc = "2+ Projects"
    ),
    Support(
        iconno = 3,
        title = "Support",
        desc = "Online 24 / 7"
    )
}
