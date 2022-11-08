package com.example.screen_home.domain.models

data class ItemHomeStoreDomain(
    val id: Int,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean
)
