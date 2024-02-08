package com.example.calclove.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calclove.LoveViewModel
import com.example.calclove.databinding.ActivityMainBinding
import com.example.calclove.onBoarding.OnBoardingPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var onBoardingPref: OnBoardingPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(!onBoardingPref.isOnboardingCompleted()){
            val intent = Intent(this@MainActivity, OnBoardingActivity::class.java)
                startActivity(intent)

        }

        binding.calculateBtn.setOnClickListener {
            val firstName = binding.firstEd.text.toString()
            val secondName = binding.secondEd.text.toString()
            viewModel.getLove(firstName, secondName).observe(this@MainActivity, Observer {
                it?.let { model ->
                    val intent = Intent(this@MainActivity, ResultActivity::class.java).apply {
                        putExtra("firstName", model.firstName)
                        putExtra("secondName", model.secondName)
                        putExtra("percentage", model.percentage)
                        putExtra("result", model.result)
                    }
                    startActivity(intent)
                }
            })

        }

    }


}