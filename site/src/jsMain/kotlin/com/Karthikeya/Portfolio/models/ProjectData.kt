package com.Karthikeya.Portfolio.models

import com.Karthikeya.Portfolio.util.Res.Imaage.project1
import com.Karthikeya.Portfolio.util.Res.Imaage.project2

enum class ProjectData(
    val image : String,
    val title : String,
    val desc : String
) {
    One(
        image = project1,
        title = "College Materials",
        desc = "Android App"
    ),
    Two(
    image = project2,
    title = "My Portfolio",
    desc = "Kobweb"
    )
}