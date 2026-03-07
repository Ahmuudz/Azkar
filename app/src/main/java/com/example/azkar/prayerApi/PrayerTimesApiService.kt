package com.example.azkar.prayerApi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesApiService {

    @GET("timingsByCity")
    suspend fun getPrayerTimesByCity(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = 4
    ): Response<PrayerTimesResponse>
}

object PrayerRetrofitInstance {
    private const val BASE_URL = "https://api.aladhan.com/v1/"

    val api: PrayerTimesApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PrayerTimesApiService::class.java)
    }
}