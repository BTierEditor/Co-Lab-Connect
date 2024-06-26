plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.co_labconnect"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.co_labconnect"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation ("com.hbb20:ccp:2.5.0")

    implementation ("com.airbnb.android:lottie:3.4.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database-ktx:20.2.2")
    implementation("com.google.firebase:firebase-storage")
    implementation("com.google.firebase:firebase-storage-ktx:20.2.1")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    implementation ("com.github.dhaval2404:imagepicker:2.1")
    implementation("com.google.firebase:firebase-firestore:24.10.2")
    implementation ("com.google.firebase:firebase-bom:32.7.2")
    implementation("androidx.activity:activity:1.8.0")
    testImplementation("junit:junit:4.13.2")
//    implementation("'com.google.gms:google-services:4.4.1'")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}