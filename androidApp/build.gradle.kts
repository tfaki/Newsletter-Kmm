plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

val composeVersion = "1.2.0-alpha01"

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.talhafaki.newsletter.android"
        minSdk = 24
        targetSdk = 32
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
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.2.0-beta03")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")

    //coil
    val version = "0.13.0"
    implementation("com.google.accompanist:accompanist-coil:${version}")

    //hilt
    val hiltVersion = "2.41"
    val hiltNavigationVersion = "1.0.0-alpha03"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation:$hiltNavigationVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    //ktor
    implementation("io.ktor:ktor-client-android:1.6.5")
}