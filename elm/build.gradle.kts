plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("maven-publish")
}

android {
    namespace = "ru.maksonic.elmakso"

    defaultConfig {
        aarMetadata {
            minCompileSdk = 26
        }

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


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    dependencies {
        implementation(platform(libs.compose.bom))
        implementation(libs.core.ktx)
        implementation(libs.compose.runtime)
        implementation(libs.lifecycle.runtime.ktx)
        implementation(libs.ui)
        implementation(libs.androidx.lifecycle.viewmodel.ktx)
    }
}




