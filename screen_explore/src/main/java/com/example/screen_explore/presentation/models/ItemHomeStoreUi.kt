package com.example.screen_explore.presentation.models

import android.os.Parcelable
import com.example.common.presentation.interfaces.DisplayableItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemHomeStoreUi(
    val id: Int,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean,
    override val itemHashCode: Int = id.hashCode()
) : DisplayableItem, Parcelable
