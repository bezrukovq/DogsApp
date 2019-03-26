package com.example.dogsapp.view.fragments.dogsList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsapp.R
import kotlinx.android.synthetic.main.number_item.view.*

class RecyclerAdapter(private var onItemClick: (String, TextView) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    var list: ArrayList<String> = arrayListOf()
    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(list[position])
        ViewCompat.setTransitionName(holder.itemView.tv_breed,position.toString())
        holder.itemView.setOnClickListener { onItemClick(list[position],holder.itemView.tv_breed) }
    }
}
