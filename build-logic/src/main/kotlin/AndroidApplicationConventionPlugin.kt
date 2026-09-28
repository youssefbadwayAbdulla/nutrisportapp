import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            pluginManager.apply("org.jetbrains.kotlin.android")
            pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = libs.version("android-compileSdk")
                defaultConfig {
                    minSdk = libs.version("android-minSdk")
                    targetSdk = libs.version("android-targetSdk")
                }
                packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro",
                        )
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
                buildFeatures.compose = true
            }

            dependencies.add("implementation", libs.library("compose-uiToolingPreview"))
            dependencies.add("debugImplementation", libs.library("compose-uiTooling"))
        }
    }
}
