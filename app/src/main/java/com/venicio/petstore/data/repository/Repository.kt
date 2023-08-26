package com.venicio.petstore.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.venicio.petstore.data.model.ProductsResponse
import com.venicio.petstore.data.network.PetStoreClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.dsl.koinApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val context: Context) {

    private val service = PetStoreClient(context).getInstanceRetrofit()

    suspend fun fetchAllProductsAPI() = service.getProductsAPI()

}