package com.example.azkar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AzkarFragment : Fragment(R.layout.fragment_azkar_recycler_view) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AzkarAdapter

    private val azkar = mutableListOf(
        "لا اله الا الله",
        "سبحان الله",
        "الحمد لله",
        "الله اكبر",
        "استغفر الله"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewAzkar)

        adapter = AzkarAdapter(azkar)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}