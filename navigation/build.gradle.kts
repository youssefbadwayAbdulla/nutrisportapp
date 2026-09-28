plugins {
    id("nutrisport.kmp.compose.feature")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(project(":feature:auth"))
    }
}

android {
    namespace = "com.compose.nutrisportapp.navigation"
}
