plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}
apply {
    plugin("kotlin-android")
}

android {
    compileSdk = 31
    buildToolsVersion = "31.0.0"
    buildFeatures.dataBinding = true

    /**
     * Create keyStore before build
     *
    signingConfigs {
    getByName("debug") {
    storeFile = file("storeDebugFilePath")
    storePassword = ""
    keyAlias = ""
    keyPassword = ""
    enableV3Signing = true
    enableV4Signing = true
    }

    create("release") {
    storeFile = file("storeReleaseFilePath")
    storePassword = ""
    keyAlias = ""
    keyPassword = ""
    enableV3Signing = true
    enableV4Signing = true
    }
    }
     */

    defaultConfig {
        applicationId = "hd.base.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true

        buildConfigField("String", "CustomKey1", "\"Value 1\"")
        buildConfigField("String", "CustomKey2", "\"Value 2\"")
    }

    flavorDimensions.add("default")
    productFlavors {
        create("dev") {
            dimension = "default"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            addManifestPlaceholders(mutableMapOf("appName" to "Base dev app"))
        }

        create("live") {
            dimension = "default"
            applicationIdSuffix = ""
            versionNameSuffix = ""
            addManifestPlaceholders(mutableMapOf("appName" to "Base pro app"))
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isJniDebuggable = true
            isRenderscriptDebuggable = true
            renderscriptOptimLevel = 3

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            /**
            signingConfig = signingConfigs["debug"]
             */
        }

        getByName("release") {
            isDebuggable = false

            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            /**
            signingConfig = signingConfigs["release"]
             */
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    sourceSets {
        getByName("main").apply {
            file("src/main/res-screen").listFiles()?.forEach {
                res.srcDirs(it.path)
            }
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
}