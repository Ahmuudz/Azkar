package com.example.azkar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.azkar.prayerApi.PrayerRetrofitInstance
import kotlinx.coroutines.launch

class PrayerFragment : Fragment(R.layout.fragment_prayer) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PrayerAdapter
    private lateinit var dateTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dateTextView = view.findViewById(R.id.dateText)
        recyclerView = view.findViewById(R.id.recyclerViewPrayer)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        adapter = PrayerAdapter(mutableListOf())
        recyclerView.adapter = adapter

        fetchPrayerTimes()
    }

    private fun fetchPrayerTimes() {
        lifecycleScope.launch {
            try {
                val response = PrayerRetrofitInstance.api.getPrayerTimesByCity("cairo", "egypt")
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!.data
                    val timings = data.timings
                    val hijri = data.date.hijri
                    val dayNameAr = hijri.weekday.ar ?: hijri.weekday.en
                    val fullDate = "${hijri.day} ${hijri.month.ar} ${hijri.year}"
                    
                    dateTextView.text = "$dayNameAr، $fullDate"

                    val prayerList = mutableListOf(
                        "الفجر - ${timings.fajr}",
                        "الظهر - ${timings.dhuhr}",
                        "العصر - ${timings.asr}",
                        "المغرب - ${timings.maghrib}",
                        "العشاء - ${timings.isha}"
                    )
                    adapter.updateData(prayerList)
                } else {
                    Log.e("PrayerFragment", "API error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("PrayerFragment", "Fetch error", e)
            }
        }
    }
}