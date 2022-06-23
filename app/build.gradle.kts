import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    compileSdk = Versions.compileSdkVersion
    namespace = "com.brainstation23.topandroidrepositories"

    defaultConfig {
        applicationId = "com.brainstation23.topandroidrepositories"
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true

        val formattedDate = SimpleDateFormat("dd-MMM-yyyy h mm a").format(Date())
        val apkName =
            "${Versions.extAppName} ($applicationId) v${defaultConfig.versionName} - $formattedDate"
        setProperty("archivesBaseName", apkName)
    }

    buildTypes {
        val baseUrl = "\"https://api.github.com\""
        val stringType = "String"

        defaultConfig {
            buildConfigField(stringType, "BASE_URL", baseUrl)
        }

        debug {
            isMinifyEnabled = true
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    // Android Support Libraries
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")
    implementation("androidx.vectordrawable:vectordrawable-animated:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.startup:startup-runtime:1.1.1")

    // Jetpack navigation
    implementation("androidx.navigation:navigation-fragment:2.5.0-rc02")
    implementation("androidx.navigation:navigation-ui:2.5.0-rc02")

    // Dependency injection
    implementation("com.google.dagger:dagger-android:2.42")
    implementation("com.google.dagger:dagger-android-support:2.42")
    kapt("com.google.dagger:dagger-android-processor:2.42")
    kapt("com.google.dagger:dagger-compiler:2.42")

    // Fast-Android-Networking
    implementation("com.github.amitshekhariitbhu:Fast-Android-Networking:1.0.2")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.7")

    // ReactiveX
    implementation("io.reactivex.rxjava3:rxjava:3.1.4")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    // Parser
    implementation("com.google.code.gson:gson:2.9.0")

    // Room Database
    implementation("androidx.room:room-rxjava2:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.13.0")
    kapt("com.github.bumptech.glide:compiler:4.13.0")

    // Fresco
    implementation("com.facebook.fresco:fresco:2.6.0")

    // Ste-tho
    implementation("com.facebook.stetho:stetho:1.6.0")
    implementation("com.facebook.stetho:stetho-okhttp3:1.6.0")

    // sdp/ssp - a scalable size unit & texts
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("com.intuit.ssp:ssp-android:1.0.6")

    // Toasty
    implementation("com.github.GrenderG:Toasty:1.5.2")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Spin-Kit
    implementation("com.github.ybq:Android-SpinKit:1.4.0")

    // Unit testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:4.5.1")

    // Instrumentation testing
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-accessibility:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-web:3.4.0")
    androidTestImplementation("androidx.test.espresso.idling:idling-concurrent:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-idling-resource:3.4.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation("androidx.test:core:1.4.0")
}

// Define versions in a single place
object Versions {
    const val extAppName = "Top Android Repositories"

    // Sdk and tools
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    const val compileSdkVersion = 32
}