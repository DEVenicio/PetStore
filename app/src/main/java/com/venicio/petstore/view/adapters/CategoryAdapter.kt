package com.venicio.petstore.view.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.venicio.petstore.data.model.Category
import com.venicio.petstore.databinding.ItemCategoryBinding

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

            Glide.with(binding.ivCategory)
                .load(dataCategory.category_image)
                //posso colocar um tratamento em caso de erro no carregamento da imagem
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivCategory)
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

