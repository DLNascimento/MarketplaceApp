package com.example.marketplaceapp.domain.model

data class HomeDomain(
    val brands: List<HomeBrandDomain>,
    val cardProduct: CardProductDomain,
    val items: List<HomeItemDomain>
)

data class HomeBrandDomain(
    val imageUrl: String,
    val type: String
)

data class CardProductDomain(
    val buttonTitle: String,
    val description: String,
    val imageUrl: String,
    val title: String
)

data class HomeItemDomain(
    val imageUrl: String,
    val price: String,
    val rating: String,
    val title: String
)