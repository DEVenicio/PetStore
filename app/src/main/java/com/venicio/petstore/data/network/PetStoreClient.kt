package com.venicio.petstore.data.network

import android.content.Context
import com.google.gson.Gson
import io.github.brunogabriel.mockpinterceptor.MockPInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PetStoreClient(context: Context) {

    private val baseUrl = "https://viacep.com.br/"
    private val gson = Gson().newBuilder().create()

    // Cria um interceptor
    private val mockpInterceptor = MockPInterceptor
        .Builder(context)
        .addDelayInMillis(1_000L, 1_000L)
        .build()

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(mockpInterceptor)
        .build()


    fun getInstanceRetrofit(): PetStoreService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        return retrofit.create(PetStoreService::class.java)
    }

}