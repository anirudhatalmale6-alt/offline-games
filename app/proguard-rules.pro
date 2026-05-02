# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.

# Keep Game model class for Gson serialization
-keep class com.gamesytstudio.offlinegames.model.** { *; }

# Keep Compose classes
-dontwarn androidx.compose.**
