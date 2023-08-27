plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "library.chipslayoutmanager"
    defaultConfig {
        applicationId = "library.chipslayoutmanager"
    }
    buildFeatures.buildConfig = true
}

dependencies {

    implementation(project(mapOf("path" to ":chips")))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}