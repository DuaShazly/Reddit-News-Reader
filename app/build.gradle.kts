
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt.android)
    id("kotlin-kapt")

    alias(libs.plugins.compose.compiler) // Add this line

}

android {
    namespace = "com.duaa.redditnewsreader"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.duaa.redditnewsreader"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get() }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation(libs.activity.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.navigation.compose)
    implementation(libs.lifecycle.vm.compose)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.coil.compose)

    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.converter)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.datastore.preferences)
    implementation(libs.kotlinx.serialization.json)
}