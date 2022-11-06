package com.example.api_my_cart_screen.models

import com.google.gson.annotations.SerializedName

data class MyCartScreenDataDto(
    @SerializedName("basket")
    val basket: List<ItemBasketDto?>,
    @SerializedName("delivery")
    val delivery: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("total")
    val total: Double?
)
