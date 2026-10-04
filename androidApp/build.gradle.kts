plugins {
    id("nutrisport.android.application")
    alias(libs.plugins.google.services)
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":di"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.splash.screen)
    implementation(libs.firebase.app)
    implementation(libs.koin.android)
}

android {
    namespace = "com.compose.nutrisportapp"

    defaultConfig {
        applicationId = "com.compose.nutrisportapp"
        versionCode = 1
        versionName = "1.0"
    }
}
