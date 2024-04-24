package com.example.myapplication.ui.repository

import com.example.myapplication.di.ApiInterface
import com.example.myapplication.di.RetrofitClient
import com.example.myapplication.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private var apiInterface = RetrofitClient.create()

    fun getData(callback: (List<DataModel>?) -> Unit) {

        apiInterface.getData().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                callback(null)
            }
        })
    }
}