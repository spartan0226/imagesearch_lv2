package com.sparta.fifth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparta.fifth.databinding.ItemsGridBinding

class RecyclerviewAdapter : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return 14
    }

    inner class ViewHolder(private val binding: ItemsGridBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}