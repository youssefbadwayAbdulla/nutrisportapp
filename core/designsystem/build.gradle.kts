plugins {
    id("nutrisport.kmp.compose.library")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.compose.foundation)
        implementation(libs.compose.material3)
    }
}

android {
    namespace = "com.compose.nutrisportapp.designsystem"
}
