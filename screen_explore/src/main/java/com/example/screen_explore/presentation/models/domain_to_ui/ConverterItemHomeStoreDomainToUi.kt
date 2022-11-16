package com.example.screen_explore.presentation.models.domain_to_ui

import com.example.screen_explore.domain.models.ItemHomeStoreDomain
import com.example.screen_explore.presentation.models.ItemHomeStoreUi
import java.util.*

fun ItemHomeStoreDomain.toItemHomeStoreUi(): ItemHomeStoreUi {
    return ItemHomeStoreUi(
        id = id,
        isNew = isNew,
        title = title,
        subtitle = subtitle,
        picture = picture,
        isBuy = isBuy
    )
}

