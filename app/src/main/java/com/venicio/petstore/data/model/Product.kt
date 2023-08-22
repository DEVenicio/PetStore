package com.venicio.petstore.data.model

data class Product(
    val current_price: Double,
    val description: String,
    val id: Int,
    val name: String,
    val old_price: Double,
    val product_image: String
)