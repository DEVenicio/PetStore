package com.venicio.petstore.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.venicio.petstore.data.model.Category
import com.venicio.petstore.data.model.Product
import com.venicio.petstore.databinding.FragmentHomeBinding
import com.venicio.petstore.view.adapters.CategoryAdapter
import com.venicio.petstore.view.adapters.ProdutcsAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerCategoryAdapter: CategoryAdapter
    private lateinit var recyclerProductByCategoryAdapter: ProdutcsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        // TODO LISTA MOCK APAGAR

        fun createSampleData(): List<Category> {

            val categories = mutableListOf<Category>()

            // Category 1
            val category1 = Category(
                id = 1,
                name = "Ração para Cães",
                category_image = "URL_IMAGEM_CATEGORIA_1",
                products = listOf(
                    Product(
                        id = 101,
                        name = "Ração Premium",
                        old_price = 29.99,
                        current_price = 24.99,
                        description = "Ração nutritiva de alta qualidade para cães.",
                        product_image = "URL_IMAGEM_PRODUTO_101"
                    ),
                    Product(
                        id = 101,
                        name = "Ração Premium 2 ",
                        old_price = 29.99,
                        current_price = 34.56,
                        description = "Ração nutritiva de alta qualidade para cães.",
                        product_image = "URL_IMAGEM_PRODUTO_101"
                    ),

                    Product(
                        id = 203,
                        name = "Ração Premium 3 ",
                        old_price = 22.99,
                        current_price = 19.99,
                        description = "Ração especial para gatos indoor.",
                        product_image = "URL_IMAGEM_PRODUTO_201"
                    ),
                )
            )
            categories.add(category1)

            val category2 = Category(
                id = 2,
                name = "Ração para Gatos",
                category_image = "URL_IMAGEM_CATEGORIA_2",
                products = listOf(
                    Product(
                        id = 201,
                        name = "Ração Indoor",
                        old_price = 22.99,
                        current_price = 19.99,
                        description = "Ração especial para gatos indoor.",
                        product_image = "URL_IMAGEM_PRODUTO_201"
                    ),
                    Product(
                        id = 202,
                        name = "Ração 2",
                        old_price = 22.99,
                        current_price = 19.99,
                        description = "Ração especial para gatos indoor.",
                        product_image = "URL_IMAGEM_PRODUTO_201"
                    ),

                    )
            )
            categories.add(category2)

            val category3 = Category(
                id = 3,
                name = "Brinquedos para Cães",
                category_image = "",
                products = listOf(
                    Product(
                        id = 301,
                        name = "Bola de Borracha",
                        old_price = 5.99,
                        current_price = 4.49,
                        description = "Bola de borracha resistente para cães brincarem.",
                        product_image = "URL_IMAGEM_PRODUTO_201"
                    ),
                )
            )
            categories.add(category3)


            return categories

        }


        setupRecyclerCategory()
        recyclerCategoryAdapter.submitList(createSampleData())

        setupRecyclerProductsByCategory()
        recyclerProductByCategoryAdapter.submitList(createSampleData())

        return (binding.root)
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

}