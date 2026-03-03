package com.example.azkar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AzkarAdapter(
    private val azkarList: MutableList<String>
) : RecyclerView.Adapter<AzkarAdapter.AzkarViewHolder>() {

     class AzkarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.azkar_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AzkarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_azkar_layout, parent, false)
        return AzkarViewHolder(view)
    }

    override fun onBindViewHolder(holder: AzkarViewHolder, position: Int) {
        holder.textView.text = azkarList[position]
    }

    override fun getItemCount(): Int {
        return azkarList.size
    }
}