package com.venicio.petstore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venicio.petstore.data.model.ProductsResponse
import com.venicio.petstore.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PetStoreViewModel(private val rp: Repository)  : ViewModel() {

   private val _getProductsApi = MutableLiveData<ProductsResponse>()
    val getProductApi: LiveData<ProductsResponse> get() = _getProductsApi

    private var countProduct = 1

    fun getProductsAll() {
        viewModelScope.launch(Dispatchers.IO) {
            _getProductsApi.postValue(rp.fetchAllProductsAPI())
        }

    }

    fun getCount(): Int {
        return countProduct
    }

    fun increment(){
        countProduct++
    }

    fun decrement() {
        if (countProduct > 1) countProduct--
    }

    fun totalProducts(price: Double): String {
        val totalPrice = price * countProduct
        return String.format("%.2f", totalPrice)
    }



    //TODO implementar lógica para verificar se tem desconto e tirar lógica do adapter

}