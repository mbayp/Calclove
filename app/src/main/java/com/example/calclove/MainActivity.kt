package com.example.calclove

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calclove.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                RetrofitService().api.getCompatibility(
                    firstEd.text.toString(),
                    secondEd.text.toString()
                ).enqueue(object : retrofit2.Callback<LoveModel> {
                    @SuppressLint("SetTextI18n")
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                                intent.putExtra("firstName", it.firstName)
                                intent.putExtra("secondName", it.secondName)
                                intent.putExtra("percentage", it.percentage)
                                intent.putExtra("result", it.result)
                                startActivity(intent)
                            }
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
}