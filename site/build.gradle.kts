import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.serialization.plugin)
}

group = "id.neotica.neotiblog"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
        }
    }
}

kotlin {
    configAsKobwebApplication("neotiblog", includeServer = true)

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.kotlinx.serialization)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(libs.silk.icons.fa)
                // implementation(libs.kobwebx.markdown)
                implementation(libs.kotlinx.serialization)
              //  implementation(libs.kmongo.database)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.kobweb.api)
                implementation(libs.kmongo.database)
                implementation(libs.mongodb.kotlin.driver)
                implementation(libs.kotlinx.serialization)
            }
        }
    }
}
