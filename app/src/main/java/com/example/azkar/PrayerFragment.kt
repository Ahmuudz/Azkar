package com.example.azkar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PrayerFragment : Fragment(R.layout.fragment_prayer) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PrayerAdapter

    private val prayers = mutableListOf(
        "الفجر - 5:10 ص",
        "الظهر - 12:05 م",
        "العصر - 3:30 م",
        "المغرب - 6:10 م",
        "العشاء - 7:30 م"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewPrayer)

        adapter = PrayerAdapter(prayers)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}