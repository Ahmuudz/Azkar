package com.example.azkar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrayerAdapter(
    private val prayerList: MutableList<String>
) : RecyclerView.Adapter<PrayerAdapter.PrayerViewHolder>() {

    inner class PrayerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.prayer_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prayer_layout, parent, false)
        return PrayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrayerViewHolder, position: Int) {
        val currentPrayer = prayerList[position]
        holder.textView.text = currentPrayer
    }

    override fun getItemCount(): Int {
        return prayerList.size
    }
}