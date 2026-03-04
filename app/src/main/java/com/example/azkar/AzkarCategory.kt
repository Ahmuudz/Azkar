package com.example.azkar

data class AzkarCategory(
    val title: String,
    val iconRes: Int
)

val azkarCategories = listOf(
    AzkarCategory("أذكار الصباح", R.drawable.sun),
    AzkarCategory("أذكار المساء", R.drawable.moon),
    AzkarCategory("أذكار الصلاة", R.drawable.islamic),
    AzkarCategory("أذكار النوم", R.drawable.sleep),
    AzkarCategory("أذكار الطعام", R.drawable.chicken),
    AzkarCategory("أذكار الاستيقاظ", R.drawable.wake),
    AzkarCategory("الأذكار اليومية", R.drawable.daily),
    AzkarCategory("الأذكار العامة", R.drawable.general)
)