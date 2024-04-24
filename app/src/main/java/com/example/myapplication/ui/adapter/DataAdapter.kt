package com.example.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDataBinding
import com.example.myapplication.model.DataModel

class DataAdapter(var context: Context,var userList:ArrayList<DataModel>): RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemDataBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemDataBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var myData = userList[position]

        holder.binding.textViewTitle.text = myData.title

    }
}