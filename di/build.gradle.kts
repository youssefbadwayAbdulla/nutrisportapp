plugins {
    id("nutrisport.kmp.compose.feature")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.koin.core)
        implementation(libs.koin.compose)
        implementation(libs.koin.compose.viewmodel)
    }
}

android {
    namespace = "com.compose.nutrisportapp.di"
}
