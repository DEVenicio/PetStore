package com.venicio.petstore.data.network

import com.venicio.petstore.data.model.ProductsResponse
import io.github.brunogabriel.mockpinterceptor.MOCK
import retrofit2.Call
import retrofit2.http.GET

interface PetStoreService {
    @MOCK(asset = "productsAPI.json", runDelay = true)
    @GET("ws/89254100/json/")
   suspend fun getProductsAPI(): ProductsResponse
}