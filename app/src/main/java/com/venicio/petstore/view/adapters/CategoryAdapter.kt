package com.venicio.petstore.view.adapters


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.venicio.petstore.data.model.Category
import com.venicio.petstore.databinding.ItemCategoryBinding
import kotlin.random.Random

class CategoryAdapter() :
    ListAdapter<Category, CategoryAdapter.CategoryVH>(DiffUtilCategory()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)

        return CategoryVH(binding)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        holder.bindCategory(getItem(position))
    }


    class CategoryVH(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindCategory(dataCategory: Category) {
            binding.tvTitleCategory.text = dataCategory.name
            binding.ivCategory.setBackgroundColor(generateRandomColor())
        }

        fun generateRandomColor(): Int {
            val alpha = 255
            val red = Random.nextInt(256)
            val green = Random.nextInt(256)
            val blue = Random.nextInt(256)

            return Color.argb(alpha, red, green, blue)
        }

    }

}

class DiffUtilCategory : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

}

