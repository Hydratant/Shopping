object Kotlin {
    private const val kotlinVersion = "1.5.21"
    const val gradlePluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
}

object Gradle {
    private const val gradleVersion = "4.2.2"
    const val gradleBuildTool = "com.android.tools.build:gradle:${gradleVersion}"
}

object AndroidX {
    private const val coreKtxVersion = "1.6.0"
    const val coreKtx = "androidx.core:core-ktx:${coreKtxVersion}"

    private const val appcompatVersion = "1.3.0"
    const val appcompat = "androidx.appcompat:appcompat:${appcompatVersion}"

    object UI {
        private const val constraintLayoutVersion = "2.0.4"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"

        private const val recyclerViewVersion = "1.2.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:${recyclerViewVersion}"

        private const val viewPager2Version = "1.0.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:$viewPager2Version"

        private const val swipeRefreshVersion = "1.1.0"
        const val swipeRefresh =
            "androidx.swiperefreshlayout:swiperefreshlayout:$swipeRefreshVersion"
    }

    object KTX {
        private const val viewModelVersion = "2.3.1"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion"

        private const val fragmentVersion = "1.3.5"
        const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
    }
}

object Material {
    private const val materialVersion = "1.4.0"
    const val material = "com.google.android.material:material:${materialVersion}"
}


object Hilt {
    private const val daggerHiltVersion = "2.38.1"
    const val gradlePluginDaggerHilt =
        "com.google.dagger:hilt-android-gradle-plugin:${daggerHiltVersion}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${daggerHiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${daggerHiltVersion}"

    const val hiltTest = "com.google.dagger:hilt-android-testing:$daggerHiltVersion"
}

object Coroutine {
    private const val coroutineVersion = "1.5.1"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutineVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"
}


object Timber {
    private const val timberVersion = "4.7.1"
    const val timber = "com.jakewharton.timber:timber:$timberVersion"
}

object Network {
    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
    private const val retrofitConverterVersion = "2.9.0"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:$retrofitConverterVersion"

    private const val okhttpVersion = "4.9.0"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
}

object Glide {
    private const val glideVersion = "4.12.0"
    const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
}

object Lottie {
    private const val lottieVersion = "3.7.0"
    const val lottie = "com.airbnb.android:lottie:$lottieVersion"
}


@Suppress("SpellCheckingInspection")
object Utils {
    private const val stethoVersion = "1.5.1"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
}


