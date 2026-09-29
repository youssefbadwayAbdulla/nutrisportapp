import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("nutrisport.kmp.compose.feature")
}

kotlin {
    targets.withType<KotlinNativeTarget>().configureEach {
        binaries.framework {
            baseName = "Shared"
            isStatic = true
            binaryOption("bundleId", "com.compose.nutrisportapp.shared")
        }
    }

    sourceSets.commonMain.dependencies {
        api(project(":core:designsystem"))
        implementation(project(":navigation"))
        implementation(libs.auth.kmp)
    }
}

android {
    namespace = "com.compose.nutrisportapp.shared"
}
