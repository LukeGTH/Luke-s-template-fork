plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.aliucord.gradle)
}

group = "com.github.MyFirstKotlinPlugin"
version = "1.0.0"

dependencies {
    implementation(libs.aliucord)
    implementation(libs.kotlin.stdlib)
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

