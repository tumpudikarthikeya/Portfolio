package com.Karthikeya.Portfolio.models

enum class QualificationData(
    val title : String,
    val subTitle : String = "Self Learning",
    val year : String ="2023 - Present"
) {
    SSC(title = "10th Class",
        subTitle = "Narayana EM School",
        year = "2019"),
    Diploma(title = "Diploma CME",
        subTitle = "AANM & VVRSR Polytechnic",
        year = "2022"),
    Btech(title = "Engineering-CSE",
        subTitle = "Gayatri Vidya Parishad, College Of Engineering (Autonomous)",
        year = "2025"),
    ML(title = "Machine Learning" ),
    Android(title = "Jetpack Compose"),
    Web(title = "Kobweb")

}