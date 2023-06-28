package com.example.textwatchertest

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val cityTextWatcher = object : TextWatcher {

        private var previousText: String = ""
        private val regex = REGEX.toRegex()

        override fun afterTextChanged(s: Editable?) {
            previousText = s.toString().filter { regex.matches(it.toString()) }

            if (!regex.matches(s.toString())) {
                s?.replace(0, s.length, previousText)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
    }

    companion object {
        private const val REGEX = "^(?!.*[-.']{2})[A-zÀ-ú '-.]*\$"
    }

}