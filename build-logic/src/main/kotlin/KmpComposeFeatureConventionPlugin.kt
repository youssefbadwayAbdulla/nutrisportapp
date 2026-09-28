import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpComposeFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        configureKmpComposeLibrary(featureDependencies = true)
    }
}
