package com.example.calclove.onBoarding

import android.content.SharedPreferences
import javax.inject.Inject

class OnBoardingPref @Inject constructor(private val pref: SharedPreferences) {

    fun isOnboardingCompleted(): Boolean{
        return pref.getBoolean("onboarding_completed", false)
    }
    fun setOnboardingCompleted(){
        pref.edit().putBoolean("onboarding_completed", true).apply()
    }
}