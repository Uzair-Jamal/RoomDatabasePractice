package com.app.roomdatabasepractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.roomdatabasepractice.databinding.ListItemBinding
import com.app.roomdatabasepractice.model.Subscriber

class MyRecyclerViewAdapter(private val subscribersList: List<Subscriber>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding: ListItemBinding =
           DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position])
    }
}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(subscriber: Subscriber){
        binding.nameTv.text = subscriber.name
        binding.emailTv.text = subscriber.email
    }
}