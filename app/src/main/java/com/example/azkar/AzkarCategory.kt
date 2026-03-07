package com.example.azkar

data class AzkarCategory(
    val title: String,
    val iconRes: Int
)

val azkarCategories = listOf(
    AzkarCategory("أذكار الصباح", R.drawable.sun),
    AzkarCategory("أذكار المساء", R.drawable.moon),
    AzkarCategory("أذكار بعد الصلاة", R.drawable.islamic),
)