import org.gradle.api.JavaVersion

object Versions {

    //Kotlin
    const val core = "1.6.0"
    const val stdlib = "1.5.30"
    const val coroutinesCore = "1.5.1"
    const val coroutinesAndroid = "1.5.1"

    //Design
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.0"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "3.12.1"
    const val adapterCoroutines = "0.9.2"

    //Koin
    const val koinCore = "2.2.3"
    const val koinAndroid = "2.2.3"
    const val koinViewModel = "2.2.3"

    //Glide
    const val glide = "4.12.0"
    const val glideCompiler = "4.12.0"

    //Test
    const val jUnit = "4.12"
    const val ext = "1.1.3"
    const val espressoCore = "3.4.0"

    // ViewBinding
    const val viewBinding = "1.4.7"

    //Cicerone
    const val cicerone = "6.6"

    // Discrete ScrollView
    const val discreteScrollView = "1.5.1"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Design {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Tests {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val ext = "androidx.test.ext:junit:${Versions.ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object DiscreteScrollView {
    const val discreteScrollView = "com.yarolegovich:discrete-scrollview:${Versions.discreteScrollView}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val coroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

    const val gson = "com.google.code.gson:gson:2.8.9"
}

object Koin {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinCore}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroid}"
    const val koinViewModel = "io.insert-koin:koin-android-viewmodel:${Versions.koinViewModel}"
}

object Cicerone {
    const val cicerone = "com.github.terrakok:cicerone:${Versions.cicerone}"
}

object Modules {
    const val model = ":model"
    const val repositories = ":repositories"
    const val core = ":core"
    const val utils = ":utils"
    const val mainScreen = ":feature-main-screen"
    const val productDetails = ":feature-product-details"
    const val splashScreen = ":feature-splash-screen"
    const val myCart = ":feature-my-cart"
}

object Config {
    const val kotlinVersion = "1.5.30"
    const val compileSdk = 30
    const val minSdk = 24
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildTools = "30.0.3"
    val javaVersion = JavaVersion.VERSION_1_8
}

object ViewBindingLibrary {
    const val viewBinding =
        "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBinding}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
}