package com.example.marketplaceapp.data.dto

data class HomeDTO(
    val brands: List<HomeBrand>,
    val cardProduct: CardProduct,
    val items: List<HomeItem>
)

data class HomeBrand(
    val imageUrl: String,
    val type: String
)

data class CardProduct(
    val buttonTitle: String,
    val description: String,
    val imageUrl: String,
    val title: String
)

data class HomeItem(
    val imageUrl: String,
    val price: String,
    val rating: String,
    val title: String
)