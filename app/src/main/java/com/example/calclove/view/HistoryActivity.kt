package com.example.calclove.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AlertDialog
import com.example.calclove.App
import com.example.calclove.R
import com.example.calclove.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvHistory.movementMethod = ScrollingMovementMethod()

        updateResult()

        binding.btnDeleteAll.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Delete All")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes") { _, _ ->
                    App.appDatabase.LoveDao().deleteAll()
                    updateResult()
                }.show()
        }

        binding.btnDelete.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Delete")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes") { _, _ ->
                    App.appDatabase.LoveDao().deleteByName(binding.etName.text.toString())
                    updateResult()
                }.show()
        }
    }

    private fun updateResult() {
        val sortedList = App.appDatabase.LoveDao().getAllSortedByName()
        var result = ""
        sortedList.forEach {
            result += "${it.firstName}\n${it.secondName}\n${it.percentage}\n${it.result}\n"
        }
        binding.tvHistory.text = result
    }
}