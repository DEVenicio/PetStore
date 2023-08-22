package com.venicio.petstore.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.venicio.petstore.data.model.Category
import com.venicio.petstore.databinding.ItemProductsRecyclerBinding

class ProdutcsAdapter :
    ListAdapter<Category, ProdutcsAdapter.CategoryProductsVH>(DiffUtilProducts()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryProductsVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductsRecyclerBinding.inflate(inflater, parent, false)

        return CategoryProductsVH(binding)
    }

    override fun onBindViewHolder(holder: CategoryProductsVH, position: Int) {
        holder.bindProducts(getItem(position))
    }


    class CategoryProductsVH(val binding: ItemProductsRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindProducts(dataProducts: Category) {
            binding.tvTitleCategoryItem.text = dataProducts.name

            with(binding.root) {
                val recycler = binding.rvSingleProducts

                val recyclerAdapter = ProductsByCategoryAdapter()

                recycler.adapter = recyclerAdapter
                recyclerAdapter.submitList(dataProducts.products)
            }
        }

    }

}


class DiffUtilProducts : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

}