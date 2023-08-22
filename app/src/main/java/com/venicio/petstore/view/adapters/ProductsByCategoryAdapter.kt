package com.venicio.petstore.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.venicio.petstore.data.model.Product
import com.venicio.petstore.databinding.ItemProductBinding

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
            binding.tvTitleProduct.text = dataProduct.name
            binding.tvOldNewValue.text = dataProduct.current_price.toString()
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