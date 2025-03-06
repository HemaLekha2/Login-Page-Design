package com.example.loginandnavigate.core.model

// Data class for Popular Items
data class PopularItem(
    val imageRes: Int,
    val title: String,
    val subTitle: String,
    val priceTag: String= "$",
    val price: String
)