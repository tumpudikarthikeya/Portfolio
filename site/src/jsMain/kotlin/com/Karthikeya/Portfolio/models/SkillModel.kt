package com.Karthikeya.Portfolio.models

enum class SkillModel(
    val skillId : Int,
    val skillData : SkillcardModel
) {
    Android(
        skillId = 1,
        skillData = SkillcardModel(domain = "Mobile & Web App Devlopment"
            , skills = listOf("Jetpack Compose","Material UI","Kobweb","Html"),
            skillrate = listOf(1,1,1,1,1))
    ),
    Languages(
        skillId = 2,
        skillData = SkillcardModel(domain = "Programming Languages"
                                    , skills = listOf("C","Java","Python","Kotlin"),
                                    skillrate = listOf(2,1,2,1))
            ),
    MachineLearning(
        skillId = 3,
        skillData = SkillcardModel(domain = "Machine Learning"
            , skills = listOf("Data Visualization","SQL"),
            skillrate = listOf(1,1))
    ),

    UIUX(
        skillId = 4,
        skillData = SkillcardModel(domain = "UiUx & Presentation"
            , skills = listOf("Figma","Canva"),
            skillrate = listOf(1,2))
    )
}