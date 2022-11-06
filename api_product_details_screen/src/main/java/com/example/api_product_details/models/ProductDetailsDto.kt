package com.example.api_product_details.models

import com.google.gson.annotations.SerializedName

data class ProductDetailsDto(
    @SerializedName("CPU")
    val cpu: String?,
    @SerializedName("camera")
    val camera: String?,
    @SerializedName("color")
    val color: List<String?>,
    @SerializedName("id")
    val id: String?,
    @SerializedName("images")
    val images: List<String?>?,
    @SerializedName("isFavorites")
    val isFavorites: Boolean?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("rating")
    val rating: Float?,
    @SerializedName("sd")
    val sd: String?,
    @SerializedName("ssd")
    val ssd: String?,
    @SerializedName("title")
    val title: String
)
