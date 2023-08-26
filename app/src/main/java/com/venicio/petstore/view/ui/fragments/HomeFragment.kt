package com.venicio.petstore.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.venicio.petstore.databinding.FragmentHomeBinding
import com.venicio.petstore.view.adapters.CategoryAdapter
import com.venicio.petstore.view.adapters.ProdutcsAdapter
import com.venicio.petstore.viewmodel.PetStoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerCategoryAdapter: CategoryAdapter
    private lateinit var recyclerProductByCategoryAdapter: ProdutcsAdapter
    private val args by navArgs<HomeFragmentArgs>()
    private val petStoreViewModel: PetStoreViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        setupObserver()
        hasProductCar()
        notReturnCar()

        return (binding.root)
    }

    private fun setupObserver() {
        petStoreViewModel.getProductsAll()
        petStoreViewModel.getProductApi.observe(viewLifecycleOwner, Observer {
            setupRecyclerCategory()
            recyclerCategoryAdapter.submitList(it.categories)

            setupRecyclerProductsByCategory()
            recyclerProductByCategoryAdapter.submitList(it.categories)
        })
    }

    private fun setupRecyclerCategory() {
        val recycler = binding.recyclerCategory
        recycler.setHasFixedSize(true)
        recyclerCategoryAdapter = CategoryAdapter()
        recycler.adapter = recyclerCategoryAdapter
    }

    fun setupRecyclerProductsByCategory() {
        val recycler = binding.recyclerProducts
        recycler.setHasFixedSize(true)
        recyclerProductByCategoryAdapter = ProdutcsAdapter()
        recycler.adapter = recyclerProductByCategoryAdapter
    }

    private fun hasProductCar() {
        if (args.valueProductAdd != null) {
            binding.containerSupermaketCarHome.visibility = View.VISIBLE
            binding.tvCurrentValueCar.text = args.valueProductAdd
        }
    }

    private fun notReturnCar() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            })
    }

}