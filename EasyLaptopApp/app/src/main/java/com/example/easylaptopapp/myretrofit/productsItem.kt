package com.example.easylaptopapp.myretrofit

import com.google.gson.annotations.SerializedName

data class productsItem(
    @SerializedName("id")  val id: Int,
    @SerializedName("nameProducts")  val nameProducts: String,
    @SerializedName("shortNameProducts")  val shortNameProducts: String,
    @SerializedName("priceProduct")  val priceProduct: Long,
    @SerializedName("priceUnit")  val priceUnit: String,
    @SerializedName("deltials")  val deltials: String,
    @SerializedName("imageSource")  val imageSource: String,


    )
