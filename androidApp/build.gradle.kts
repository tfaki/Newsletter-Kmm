plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

val composeVersion = "1.3.0-rc01"

android {
    compileSdk = 33
    namespace = "com.talhafaki.newsletter.android"
    defaultConfig {
        applicationId = "com.talhafaki.newsletter.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.activity:activity-compose:1.6.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.3.0-rc01")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")

    //coil
    val version = "0.13.0"
    implementation("com.google.accompanist:accompanist-coil:${version}")

    //hilt
    val hiltVersion = "2.44"
    val hiltNavigationVersion = "1.0.0"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation:$hiltNavigationVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    //ktor
    implementation("io.ktor:ktor-client-android:2.1.0")
}