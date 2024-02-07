package com.example.calclove.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calclove.LoveViewModel
import com.example.calclove.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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