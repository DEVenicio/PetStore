package com.venicio.petstore.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @SerializedName("current_price")
    val currentPrice: Double,
    val description: String,
    val id: Int,
    val name: String,
    @SerializedName("old_price")
    val oldPrice: Double,
    @SerializedName("product_image")
    val productImage: String?,
    val discount: String?
) : Parcelable