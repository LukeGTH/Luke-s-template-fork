plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.aliucord.gradle")
}

android {
    namespace = "dev.alucord.plugins"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.aliucord)
    implementation(libs.kotlin.stdlib)
    compileOnly("com.aliucord:api:2.0.0-beta.1")
}

// Tarefa para criar o .zip para o Aliucord
tasks.register<Zip>("zipPlugin") {
    from(tasks.jar.get().archiveFile.get())
    archiveFileName.set("MyFirstKotlinPlugin.zip")
    destinationDirectory.set(file("build/distributions"))
}

// Aliucord plugin settings
configure<com.aliucord.gradle.AliucordExtension> {
    pluginId.set("com.github.MyFirstKotlinPlugin")
    pluginName.set("MyFirstKotlinPlugin")
    pluginVersion.set(version.toString())
    description.set("My first Aliucord plugin written in Kotlin")
    author.set("MyName")
}

// ktlint settings
configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    version.set("0.50.0")
    ignoreFailures.set(true)
    outputToConsole.set(true)
}

