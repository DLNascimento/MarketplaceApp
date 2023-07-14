package com.example.marketplaceapp.model

import com.example.marketplaceapp.R

data class BrandList(
    val imageBrand: Int,
) {

    companion object {
        fun mock(): MutableList<BrandList> {
            val image1 = BrandList(
                R.drawable.nike
            )

            val image2 = BrandList(
                R.drawable.adidas
            )
            val image3 = BrandList(
                R.drawable.puma
            )
            val image4 = BrandList(
                R.drawable.mizuno
            )
            val image5 = BrandList(
                R.drawable.reebok
            )

            val brandList: MutableList<BrandList> = mutableListOf()
            brandList.add(image1)
            brandList.add(image2)
            brandList.add(image3)
            brandList.add(image4)
            brandList.add(image5)
            return brandList
        }

    }
}
