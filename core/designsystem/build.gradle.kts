plugins {
    id("nutrisport.kmp.compose.library")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.compose.foundation)
        implementation(libs.compose.material3)
        implementation(project(":di"))

    }
}

android {
    namespace = "com.compose.nutrisportapp.designsystem"
}
