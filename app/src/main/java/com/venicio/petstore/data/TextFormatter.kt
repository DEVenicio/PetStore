package com.venicio.petstore.data

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan

object TextFormatter {
    fun getFormattedDiscount(discount: String): String {
        return "$discount OFF"
    }

    fun getFormattedPrice(price: Double): String {
        return "R$ $price"
    }

    fun getFormattedOldPrice(price: Double): CharSequence {
        val spannableString = SpannableString("De: R$ $price")
        spannableString.setSpan(StrikethroughSpan(), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        return spannableString
    }

    fun getFormattedNewPrice(price: Double): String {
        return "Por: R$ $price"
    }
}