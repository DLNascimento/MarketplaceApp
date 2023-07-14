package com.example.marketplaceapp.model

import com.example.marketplaceapp.R

data class NewArrivalList(
    val shoesTitle : String,
    val shoesPrice: String,
    val shoesImage: Int
){
    companion object{
        fun mock(): MutableList<NewArrivalList>{
            val shoes1 = NewArrivalList(
                "Nike Pegasus",
                "$83.79",
                R.drawable.pegasusnike
            )

            val shoes2 = NewArrivalList(
                "Nike Pegasus",
                "$83.79",
                R.drawable.pegasusnike
            )

            val shoes3 = NewArrivalList(
                "Nike Pegasus",
                "$83.79",
                R.drawable.pegasusnike
            )

            val shoes4 = NewArrivalList(
                "Nike Pegasus",
                "$83.79",
                R.drawable.pegasusnike
            )

            val newArrivalList : MutableList<NewArrivalList> = mutableListOf()
            newArrivalList.add(shoes1)
            newArrivalList.add(shoes2)
            newArrivalList.add(shoes3)
            newArrivalList.add(shoes4)
            return newArrivalList
        }
    }
}
