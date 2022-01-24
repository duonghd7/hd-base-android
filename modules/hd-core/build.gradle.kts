plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    /*Koin - Dependency Injection*/
    api("io.insert-koin:koin-android:3.1.5")

    /*Rest client*/
    api("com.google.code.gson:gson:2.8.6")
    api("com.squareup.okhttp3:okhttp:4.9.1")
    api("com.squareup.okhttp3:logging-interceptor:4.9.1")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    api("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    api("io.reactivex.rxjava3:rxjava:3.0.6")
    api("io.reactivex.rxjava3:rxandroid:3.0.0")
}