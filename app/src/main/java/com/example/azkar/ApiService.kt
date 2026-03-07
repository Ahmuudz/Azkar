package com.example.azkar

import AzkarResponse
import retrofit2.Response
import retrofit2.http.GET

interface AzkarApiService {

    @GET("azkar_sabah.json")
    suspend fun getMorningAzkar(): Response<AzkarResponse>

    @GET("azkar_massa.json")
    suspend fun getEveningAzkar(): Response<AzkarResponse>

    @GET("PostPrayer_azkar.json")
    suspend fun getPrayerAzkar(): Response<AzkarResponse>

}