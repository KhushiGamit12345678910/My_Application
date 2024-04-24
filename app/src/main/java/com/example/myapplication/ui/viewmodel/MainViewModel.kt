package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.DataModel
import com.example.myapplication.ui.repository.MainRepository

class MainViewModel(): ViewModel(){
    private val mainRepository = MainRepository()
    private val _data = MutableLiveData<List<DataModel>>()
    val data: LiveData<List<DataModel>>
        get() = _data

    fun fetchData() {
        mainRepository.getData { result ->
            _data.value = result
        }
    }

}