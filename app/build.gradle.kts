plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.uclab4"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.uclab4"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("androidx.fragment:fragment:1.9.1")
}
