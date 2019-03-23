package com.example.dogsapp.view.fragments.dogsList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.number_item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindViews(string: String) {
        itemView.tv_date.text = string
    }
}
