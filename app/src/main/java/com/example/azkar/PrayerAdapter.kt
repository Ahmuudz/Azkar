package com.example.azkar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrayerAdapter(
    private var prayerList: MutableList<String>
) : RecyclerView.Adapter<PrayerAdapter.PrayerViewHolder>() {

    class PrayerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.prayer_text)
    }

    fun updateData(newList: MutableList<String>) {
        this.prayerList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prayer_layout, parent, false)
        return PrayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrayerViewHolder, position: Int) {
        holder.textView.text = prayerList[position]
    }

    override fun getItemCount(): Int = prayerList.size
}