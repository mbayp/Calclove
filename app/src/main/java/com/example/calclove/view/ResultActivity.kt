package com.example.calclove.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calclove.App
import com.example.calclove.R
import com.example.calclove.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("firstName")
        val secondName = intent.getStringExtra("secondName")
        val percentage = intent.getStringExtra("percentage")
        val result = intent.getStringExtra("result")



        binding.resultTV.text = "$firstName\n$secondName\n$percentage\n$result"
    }
}

