package com.venicio.petstore.di

import com.venicio.petstore.data.repository.Repository
import com.venicio.petstore.viewmodel.PetStoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { PetStoreViewModel(get()) }
    single { Repository(get()) }
}

