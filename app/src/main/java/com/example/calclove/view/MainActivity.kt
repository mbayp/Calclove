package com.example.calclove.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calclove.LoveViewModel
import com.example.calclove.remote.RetrofitService
import com.example.calclove.databinding.ActivityMainBinding
import com.example.calclove.remote.LoveModel
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val viewModel : LoveViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.calculateBtn.setOnClickListener {
            val firstName = binding.firstEd.text.toString()
            val secondName = binding.secondEd.text.toString()
            viewModel.getLove(firstName = firstName, secondName = secondName).observe(this@MainActivity, Observer {
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
