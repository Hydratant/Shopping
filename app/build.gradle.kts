plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}
android {

    compileSdkVersion(ProjectConfig.compileSdkVersion)
    buildToolsVersion(ProjectConfig.buildToolVersion)

    defaultConfig {
        applicationId(ProjectConfig.applicationId)
        minSdkVersion(ProjectConfig.minSdkVersion)
        targetSdkVersion(ProjectConfig.targetSdkVersion)
        versionCode(ProjectConfig.versionCode)
        versionName(ProjectConfig.versionName)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    testOptions.unitTests {
        isIncludeAndroidResources = true
        isReturnDefaultValues = true
    }
}
dependencies {
    implementation(Kotlin.kotlinStdLib)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.UI.constraintLayout)
    implementation(AndroidX.UI.recyclerView)
    implementation(AndroidX.UI.viewpager2)
    implementation(AndroidX.UI.swipeRefresh)
    implementation(AndroidX.KTX.fragment)
    implementation(AndroidX.KTX.viewModel)
    implementation(Material.material)

    // NetWork
    implementation(Network.retrofit)
    implementation(Network.retrofitConverter)
    implementation(Network.okHttp)
    implementation(Network.okHttpLogging)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)

    // Coroutine
    implementation(Coroutine.coroutine)
    implementation(Coroutine.coroutinesAndroid)

    // Log
    implementation(Timber.timber)

    // Glide (Image)
    implementation(Glide.glide)
    kapt(Glide.glideCompiler)

    // Lottie
    implementation(Lottie.lottie)


    // Test
    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.mockitoInline)
    testImplementation(UnitTest.mockitoKotlin)
    testImplementation(UnitTest.hamcrest)
    testImplementation(UnitTest.robolectric)
    implementation(UnitTest.testCore)
}
