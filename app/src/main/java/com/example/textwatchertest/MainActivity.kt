package com.example.textwatchertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var edtText: EditText
    private lateinit var tvText: TextView

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtText = findViewById(R.id.edtInput)
        tvText = findViewById(R.id.tvText)

        edtText.addTextChangedListener(viewModel.cityTextWatcher)
    }

}