package com.example.screen_explore.presentation.models

import androidx.annotation.DrawableRes
import com.example.common.presentation.interfaces.DisplayableItem
import com.example.screen_explore.R

enum class SelectCategory(
    val title: String,
    @DrawableRes val selectIcon: Int,
    @DrawableRes val unselectIcon: Int,
    var isSelected: Boolean = false,
) : DisplayableItem {

    PHONE(
        title = "Phones",
        selectIcon = R.drawable.ic_phone_white,
        unselectIcon = R.drawable.ic_phone_gray,
        isSelected = true,
    ),
    COMPUTER(
        title = "Computer",
        selectIcon = R.drawable.ic_computer_white,
        unselectIcon = R.drawable.ic_computer_gray
    ),
    HEALTH(
        title = "Health",
        selectIcon = R.drawable.ic_health_white,
        unselectIcon = R.drawable.ic_health_gray
    ),
    BOOKS(
        title = "Books",
        selectIcon = R.drawable.ic_books_white,
        unselectIcon = R.drawable.ic_books_gray,
    );

    override val itemHashCode get() = title.hashCode() + isSelected.hashCode()
}
