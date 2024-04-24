package com.example.myapplication.di

import com.example.myapplication.consts.DATA
import com.example.myapplication.model.DataModel
import retrofit2.http.GET

interface ApiInterface {
    @GET(DATA)
    fun getData(): retrofit2.Call<List<DataModel>> // Change DataModel to your actual model

}