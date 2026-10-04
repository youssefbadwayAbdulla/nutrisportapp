plugins {
    id("nutrisport.kmp.compose.feature")
    alias(libs.plugins.serialization)

}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(project(":core:designsystem"))
        implementation(project(":feature:auth"))
        implementation(libs.compose.navigation)
        implementation(libs.kotlinx.serialization)

    }
}

android {
    namespace = "com.compose.nutrisportapp.navigation"
}
