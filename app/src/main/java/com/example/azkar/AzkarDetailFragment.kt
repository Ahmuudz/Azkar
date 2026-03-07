package com.example.azkar

import AzkarContent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class AzkarDetailFragment : Fragment(R.layout.fragment_azkar_detail) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AzkarDetailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val categoryTitle = arguments?.getString("category_title") ?: ""
        view.findViewById<TextView>(R.id.detail_title).text = categoryTitle

        recyclerView = view.findViewById(R.id.recyclerViewAzkarDetail)
        adapter = AzkarDetailAdapter(emptyList<AzkarContent>())
        recyclerView.adapter = adapter

        when (categoryTitle) {
            "أذكار الصباح" -> fetchMorningAzkar()
            "أذكار المساء" -> fetchEveningAzkar()
            "أذكار بعد الصلاة"-> fetchPrayerAzkar()


        }
    }

    private fun fetchMorningAzkar() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getMorningAzkar()
                if (response.isSuccessful && response.body() != null) {
                    adapter.updateData(response.body()!!.content)
                } else {
                    Log.e("AzkarDetailFragment", "API error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("AzkarDetailFragment", "Fetch error", e)
            }
        }
    }

    private fun fetchEveningAzkar() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getEveningAzkar()
                if (response.isSuccessful && response.body() != null) {
                    adapter.updateData(response.body()!!.content)
                } else {
                    Log.e("AzkarDetailFragment", "API error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("AzkarDetailFragment", "Fetch error", e)
            }
        }
    }
    private fun fetchPrayerAzkar() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getPrayerAzkar()
                if (response.isSuccessful && response.body() != null) {
                    adapter.updateData(response.body()!!.content)
                } else {
                    Log.e("AzkarDetailFragment", "API error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("AzkarDetailFragment", "Fetch error", e)
            }
        }
    }
}




class AzkarDetailAdapter(private var contents: List<AzkarContent>) : 
    RecyclerView.Adapter<AzkarDetailAdapter.DetailViewHolder>() {

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contentText: TextView = itemView.findViewById(R.id.azkar_content)
        val countText: TextView = itemView.findViewById(R.id.azkar_count)
    }

    fun updateData(newContents: List<AzkarContent>) {
        this.contents = newContents
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_azkar_detail_layout, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val content = contents[position]
        holder.contentText.text = content.zekr
        holder.countText.text = "التكرار: ${content.repeat}"
    }

    override fun getItemCount(): Int = contents.size
}