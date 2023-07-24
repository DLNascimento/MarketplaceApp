package com.example.marketplaceapp.data.mapper

import com.example.marketplaceapp.data.dto.CardProduct
import com.example.marketplaceapp.data.dto.HomeBrand
import com.example.marketplaceapp.data.dto.HomeDTO
import com.example.marketplaceapp.data.dto.HomeItem
import com.example.marketplaceapp.domain.model.CardProductDomain
import com.example.marketplaceapp.domain.model.HomeBrandDomain
import com.example.marketplaceapp.domain.model.HomeDomain
import com.example.marketplaceapp.domain.model.HomeItemDomain

fun HomeDTO.toDomain(): HomeDomain{

    val brandsDomainList = brands.map { it.toDomain() }
    val itemsDomainList = items.map { it.toDomain() }

    return HomeDomain(
        brandsDomainList,
        cardProduct.toDomain(),
        itemsDomainList
    )
}

fun HomeBrand.toDomain(): HomeBrandDomain{
    return HomeBrandDomain(
        imageUrl,
        type
    )
}

fun CardProduct.toDomain(): CardProductDomain{
    return CardProductDomain(
        buttonTitle,
        description,
        imageUrl,
        title
    )
}

fun HomeItem.toDomain(): HomeItemDomain{
    return HomeItemDomain(
        imageUrl,
        price,
        rating,
        title
    )
}

