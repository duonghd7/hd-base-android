// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlinVersion = "1.6.10"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}