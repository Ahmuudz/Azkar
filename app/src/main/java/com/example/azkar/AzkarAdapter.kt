package com.example.azkar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AzkarCategoryAdapter(
    private val categories: List<AzkarCategory>,
    private val onItemClick: (AzkarCategory) -> Unit
) : RecyclerView.Adapter<AzkarCategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.category_icon)
        val title: TextView = itemView.findViewById(R.id.category_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_azkar_layout, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.icon.setImageResource(category.iconRes)
        holder.title.text = category.title
        
        holder.itemView.setOnClickListener {
            Log.d("AzkarCategoryAdapter", "Clicked on: ${category.title}")
            onItemClick(category)
        }
    }

    override fun getItemCount(): Int = categories.size
}