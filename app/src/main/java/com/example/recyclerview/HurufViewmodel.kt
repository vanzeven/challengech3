package com.example.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HurufViewmodel : ViewModel() {
    private val _huruf: MutableLiveData<String> = MutableLiveData()
    val huruf: LiveData<String> get() = _huruf

    fun getHuruf(huruf: String) {
        _huruf.value = huruf
    }
}