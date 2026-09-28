import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpComposeLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        configureKmpComposeLibrary(featureDependencies = false)
    }
}
