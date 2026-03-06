package com.example.azkar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class AzkarDetailFragment : Fragment(R.layout.fragment_azkar_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val categoryTitle = arguments?.getString("category_title") ?: ""
        view.findViewById<TextView>(R.id.detail_title).text = categoryTitle

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewAzkarDetail)
        
        // Mock data for the content of the category
        val contents = listOf(
            "سبحان الله وبحمده",
            "استغفر الله واتوب اليه",
            "لا اله الا الله وحده لا شريك له",
            "اللهم صل وسلم على نبينا محمد"
        )
        
        recyclerView.adapter = AzkarDetailAdapter(contents)
    }
}

class AzkarDetailAdapter(private val contents: List<String>) : 
    RecyclerView.Adapter<AzkarDetailAdapter.DetailViewHolder>() {

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contentText: TextView = itemView.findViewById(R.id.azkar_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_azkar_detail_layout, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.contentText.text = contents[position]
    }

    override fun getItemCount(): Int = contents.size
}