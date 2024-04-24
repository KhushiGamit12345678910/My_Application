package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.DataModel
import com.example.myapplication.ui.adapter.DataAdapter
import com.example.myapplication.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private lateinit var dataAdapter : DataAdapter // Create your adapter class
    lateinit var binding: ActivityMainBinding

    var userList : ArrayList<DataModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        dataAdapter = DataAdapter(this,userList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = dataAdapter

        mainViewModel.data.observe(this) { data ->
            //dataAdapter.setData(data)
            userList.addAll(data)
            //dataAdapter = DataAdapter(this,userList)
        }

        mainViewModel.fetchData()

    }
}