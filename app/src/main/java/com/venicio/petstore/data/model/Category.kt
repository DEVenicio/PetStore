package com.venicio.petstore.data.model

data class Category(
    val category_image: String,
    val id: Int,
    val name: String,
    val products: List<Product>
)