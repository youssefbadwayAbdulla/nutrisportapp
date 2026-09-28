import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKmpComposeLibrary(
    featureDependencies: Boolean,
) {
    pluginManager.apply("org.jetbrains.kotlin.multiplatform")
    pluginManager.apply("com.android.library")
    pluginManager.apply("org.jetbrains.compose")
    pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

    extensions.configure<KotlinMultiplatformExtension> {
        androidTarget {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_11)
            }
        }
        iosArm64()
        iosSimulatorArm64()

        sourceSets.apply {
            getByName("androidMain").dependencies {
                implementation(libs.library("compose-uiToolingPreview"))
            }
            getByName("commonMain").dependencies {
                implementation(libs.library("compose-runtime"))
                implementation(libs.library("compose-ui"))
                implementation(libs.library("compose-components-resources"))

                if (featureDependencies) {
                    implementation(libs.library("compose-foundation"))
                    implementation(libs.library("compose-material3"))
                    implementation(libs.library("compose-components-uiToolingPreview"))
                    implementation(libs.library("androidx-lifecycle-viewmodelCompose"))
                    implementation(libs.library("androidx-lifecycle-runtimeCompose"))
                }
            }
            getByName("commonTest").dependencies {
                implementation(libs.library("kotlin-test"))
            }
            getByName("androidUnitTest").kotlin.srcDir("src/androidHostTest/kotlin")
        }
    }

    extensions.configure<LibraryExtension> {
        compileSdk = libs.version("android-compileSdk")
        defaultConfig {
            minSdk = libs.version("android-minSdk")
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        buildFeatures.compose = true
        testOptions.unitTests.isIncludeAndroidResources = true
    }

    dependencies.add("debugImplementation", libs.library("compose-uiTooling"))
}
