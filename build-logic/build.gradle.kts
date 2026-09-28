plugins {
    `kotlin-dsl`
}

group = "com.compose.nutrisportapp.buildlogic"

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.compose.gradlePlugin)
    implementation(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "nutrisport.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("kmpComposeLibrary") {
            id = "nutrisport.kmp.compose.library"
            implementationClass = "KmpComposeLibraryConventionPlugin"
        }
        register("kmpComposeFeature") {
            id = "nutrisport.kmp.compose.feature"
            implementationClass = "KmpComposeFeatureConventionPlugin"
        }
    }
}
