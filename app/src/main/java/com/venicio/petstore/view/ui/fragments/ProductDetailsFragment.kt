package com.venicio.petstore.view.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.venicio.petstore.R
import com.venicio.petstore.data.repository.Repository
import com.venicio.petstore.databinding.FragmentProductDetailsBinding
import com.venicio.petstore.viewmodel.PetStoreViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private val args by navArgs<ProductDetailsFragmentArgs>()
    private val petStoreViewModel: PetStoreViewModel by viewModel()
    private lateinit var totalProduct: String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)

        with(binding) {

            Glide
                .with(ivProductDetail)
                .load(args.productArg.productImage)
                .error(R.drawable.bg_default_products)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivProductDetail)

            tvTitleProductDetail.text = args.productArg.name
            tvDescriptionProduct.text = args.productArg.description

            updateCountAndValueCar()

            tvIncreaseProduct.setOnClickListener {
                petStoreViewModel.increment()
                updateCountAndValueCar()
            }

            tvDecreaseProduct.setOnClickListener {
                petStoreViewModel.decrement()
                updateCountAndValueCar()
               }

            }

        setupObservationProduct()

        binding.llAddToCar.setOnClickListener {
                addToSupermarketCar()
        }


        return (binding.root)
    }



    private fun updateCountAndValueCar() {
        totalProduct = petStoreViewModel.totalProducts(args.productArg.currentPrice)

        binding.tvTotalProductValue.text =  getString(R.string.total_products_single, totalProduct)
        binding.tvAmountProducts.text = petStoreViewModel.getCount().toString()
    }


    private fun setupObservationProduct() {

        val editText = binding.etObservation
        val maxCharacterLimit = 500

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(
                textChange: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                textChange?.let {
                    val currentLength = it.length
                    binding.limitTextCurrent.text = "$currentLength/$maxCharacterLimit"
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun addToSupermarketCar() {
        val direction = ProductDetailsFragmentDirections.actionProductDetailsFragmentToHomeFragment(totalProduct)
        findNavController().navigate(direction)
    }

}