pluginManagement {
    repositories {
        mavenLocal()
        google()

        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.gradle.enterprise") version "3.11.3"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "1.7.2"
}

gradleEnterprise {
    server = "https://ge.solutions-team.gradle.com/"

    allowUntrustedServer = true
    buildScan {
        publishAlways()
        capture {
            isTaskInputFiles = true
        }
        isUploadInBackground = System.getenv("CI") == null
    }
}

rootProject.name = "wireexample"
include(":android-app-kotlin-sample")
