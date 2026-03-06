package com.example.azkar

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AzkarFragment : Fragment(R.layout.fragment_azkar_recycler_view) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AzkarCategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewAzkar)

        adapter = AzkarCategoryAdapter(azkarCategories) { category ->
            val bundle = bundleOf("category_title" to category.title)
            // Updated to match the new action ID in nav_graph.xml
            findNavController().navigate(R.id.action_azkar_fragment_to_azkarDetailFragment, bundle)
        }
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}