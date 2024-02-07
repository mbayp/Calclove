package com.example.calclove.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calclove.R
import com.example.calclove.databinding.ActivityOnBoardingBinding
import com.example.calclove.onBoarding.OnBoardingAdapter
import com.example.calclove.onBoarding.OnBoardingPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    @Inject
    lateinit var onBoardingPref: OnBoardingPref
    private var adapter = OnBoardingAdapter(this::onClick)

    private lateinit var binding: ActivityOnBoardingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun onClick(){
        onBoardingPref.setOnboardingCompleted()
        startActivity(Intent(this@OnBoardingActivity,MainActivity::class.java))
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = adapter
    }

}