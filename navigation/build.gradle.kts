plugins {
    id("nutrisport.kmp.compose.feature")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(project(":core:designsystem"))
        implementation(project(":feature:auth"))
    }
}

android {
    namespace = "com.compose.nutrisportapp.navigation"
}
