plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")

    kotlin("plugin.serialization") version Deps.Version.kotlin
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.animation)
                implementation(compose.animationGraphics)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                // DateTIme
                implementation(Deps.Kotlinx.DateTime.dateTime)
                // safe area protected insets
                implementation(Deps.Insets.insetx)
                // Koin
                implementation(Deps.Koin.core)
                // Logging
                implementation(Deps.Logging.napier)
                // Precompose
                with(Deps.Precompose) {
                    api(precompose)
                    api(precomposeViewModel)
//                    api(precomposeMolecule)
                }
                api(project(":shared:media"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                //put your android dependencies here
                // add on

                // Compose
                implementation(Deps.Android.appcompat)
                implementation(Deps.Android.activityCompose)
                // KTOR
                implementation(Deps.Ktor.ktorAndroid)
                // koin
                implementation(Deps.Koin.android)
            }
        }
        val iosMain by getting {
            dependencies {
                //put your ios dependencies here
                // add on

                // KTOR
                implementation(Deps.Ktor.ktorIOS)
            }
        }
    }
}

android {
    namespace = Configurations.applicationId
    compileSdk = Configurations.compileSdk
    defaultConfig {
        minSdk = Configurations.minSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}