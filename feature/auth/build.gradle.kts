plugins {
    id("nutrisport.kmp.compose.feature")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.messagebar.kmp)
        implementation(libs.auth.kmp)
        implementation(libs.auth.firebase.kmp)
        implementation(project(":core:designsystem"))
    }
}

android {
    namespace = "com.compose.nutrisportapp.auth"
}
