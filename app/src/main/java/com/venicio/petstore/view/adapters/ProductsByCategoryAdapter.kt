package com.venicio.petstore.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.venicio.petstore.R
import com.venicio.petstore.data.TextFormatter
import com.venicio.petstore.data.model.Product
import com.venicio.petstore.databinding.ItemProductBinding
import com.venicio.petstore.view.ui.fragments.HomeFragmentDirections

class ProductsByCategoryAdapter() :
    ListAdapter<Product, ProductsByCategoryAdapter.ProductsByCategoryVH>(DiffUtilProductsByCategory()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsByCategoryVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)

        return ProductsByCategoryVH(binding)
    }

    override fun onBindViewHolder(holder: ProductsByCategoryVH, position: Int) {
        holder.bindProduct(getItem(position))
    }


    class ProductsByCategoryVH(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindProduct(dataProduct: Product) {
            with(binding) {
                Glide
                    .with(ivProduct)
                    .load(dataProduct.productImage)
                    .error(R.drawable.bg_default_products)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivProduct)

                tvTitleProduct.text = dataProduct.name

                if(dataProduct.discount != null) {
                    tvDiscount.visibility = View.VISIBLE
                    tvDiscount.text = TextFormatter.getFormattedDiscount(dataProduct.discount)
                    tvOldPriceValue.visibility = View.VISIBLE
                    tvOldPriceValue.text = TextFormatter.getFormattedOldPrice(dataProduct.oldPrice)
                    tvNewPriceValue.text = TextFormatter.getFormattedNewPrice(dataProduct.currentPrice)
                } else {
                    tvNewPriceValue.text = TextFormatter.getFormattedPrice(dataProduct.currentPrice)
                }

                cvProducts.setOnClickListener {
                    val direction =
                        HomeFragmentDirections.actionHomeFragmentToProductDetailsFragment(
                            dataProduct
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }

    }

}

class DiffUtilProductsByCategory : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }

}