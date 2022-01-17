plugins {
    id("com.android.application")
    kotlin("android")
    id("com.mikepenz.aboutlibraries.plugin")
}

android {
    compileSdk = Versions.androidCompileSdk

    defaultConfig {
        applicationId = "com.mikepenz.storyblok"
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk

        versionCode = 100
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

kotlinter {
    disabledRules = arrayOf("no-wildcard-imports")
}

dependencies {
    with(Deps.Android) {
        implementation(material)
    }

    with(Deps.MarkdownRenderer) {
        implementation(core)
    }

    with(Deps.AndroidX) {
        implementation(lifecycleRuntimeKtx)
        implementation(lifecycleViewmodelKtx)
        implementation(activityCompose)
    }

    with(Deps.Kotlinx) {
        implementation(coroutinesCore)
        implementation(serializationCore)
        implementation(serializationJson)
        implementation(dateTime)
    }

    with(Deps.Compose) {
        implementation(ui)
        implementation(uiGraphics)
        implementation(foundationLayout)
        implementation(material)
        implementation(navigation)
        implementation(coilCompose)
        implementation(accompanistInsets)
        implementation(accompanistInsetsUi)
        implementation(accompanistNavigationAnimation)
        implementation(uiTooling)
        implementation(aboutLibraries)
    }

    with(Deps.Koin) {
        implementation(core)
        implementation(android)
        implementation(compose)
        testImplementation(test)
        testImplementation(testJUnit4)
    }

    with(Deps.Test) {
        testImplementation(junit)
        androidTestImplementation(androidXTestJUnit)
        testImplementation(testCore)
        testImplementation(robolectric)
        testImplementation(mockito)

        // Compose testing dependencies
        androidTestImplementation(composeUiTest)
        androidTestImplementation(composeUiTestJUnit)
        debugImplementation(composeUiTestManifest)
    }

    implementation(project(":common"))
}