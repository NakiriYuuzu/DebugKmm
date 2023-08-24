plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "media"
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
                implementation(compose.material3)
                implementation(compose.foundation)
                implementation(compose.animationGraphics)
                implementation(compose.materialIconsExtended)
                implementation(Deps.Kotlinx.DateTime.dateTime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.exifinterface:exifinterface:1.3.6")
                implementation(Deps.Android.appcompat)
            }
        }
        val iosMain by getting {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "net.yuuzu.media"
    compileSdk = Configurations.compileSdk
    defaultConfig {
        minSdk = Configurations.minSdk
    }
}