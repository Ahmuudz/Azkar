package com.example.azkar.prayerApi

import com.google.gson.annotations.SerializedName

data class PrayerTimesResponse(
    @SerializedName("data")
    val data: PrayerData
)

data class PrayerData(
    @SerializedName("timings")
    val timings: Timings,
    @SerializedName("date")
    val date: DateInfo
)

data class Timings(
    @SerializedName("Fajr") val fajr: String,
    @SerializedName("Sunrise") val sunrise: String,
    @SerializedName("Dhuhr") val dhuhr: String,
    @SerializedName("Asr") val asr: String,
    @SerializedName("Sunset") val sunset: String,
    @SerializedName("Maghrib") val maghrib: String,
    @SerializedName("Isha") val isha: String
)

data class DateInfo(
    @SerializedName("readable") val readable: String,
    @SerializedName("hijri") val hijri: HijriDate,
    @SerializedName("gregorian") val gregorian: GregorianDate
)

data class HijriDate(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: String,
    @SerializedName("month") val month: HijriMonth,
    @SerializedName("year") val year: String,
    @SerializedName("weekday") val weekday: Weekday
)

data class GregorianDate(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: String,
    @SerializedName("month") val month: GregorianMonth,
    @SerializedName("year") val year: String,
    @SerializedName("weekday") val weekday: Weekday
)

data class HijriMonth(
    @SerializedName("number") val number: Int,
    @SerializedName("en") val en: String,
    @SerializedName("ar") val ar: String
)

data class GregorianMonth(
    @SerializedName("number") val number: Int,
    @SerializedName("en") val en: String
)

data class Weekday(
    @SerializedName("en") val en: String,
    @SerializedName("ar") val ar: String? = null
)