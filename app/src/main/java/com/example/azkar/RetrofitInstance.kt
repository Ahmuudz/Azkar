
package com.example.azkar

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

   private const val BASE_URL = "https://ahegazy.github.io/muslimKit/json/"
    val api: AzkarApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AzkarApiService::class.java)
    }

    }
