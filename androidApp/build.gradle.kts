plugins {
    id("nutrisport.android.application")
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.splash.screen)
}

android {
    namespace = "com.compose.nutrisportapp"

    defaultConfig {
        applicationId = "com.compose.nutrisportapp"
        versionCode = 1
        versionName = "1.0"
    }
}
