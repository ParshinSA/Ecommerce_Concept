package com.example.screen_explore.presentation.adapters

import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.common.extensions.inflate
import com.example.common.presentation.interfaces.DisplayableItem
import com.example.screen_explore.R
import com.example.screen_explore.databinding.ItemRvBestSellerBinding
import com.example.screen_explore.presentation.adapters.ItemBestSellerAdapterDelegate.BestSellerHolder
import com.example.screen_explore.presentation.models.ItemBestSellerUi
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ItemBestSellerAdapterDelegate(
    private val favoriteChange: (item: ItemBestSellerUi) -> Unit
) : AbsListItemAdapterDelegate<ItemBestSellerUi, DisplayableItem, BestSellerHolder>() {

    override fun isForViewType(
        item: DisplayableItem,
        items: MutableList<DisplayableItem>,
        position: Int
    ) = item is ItemBestSellerUi

    override fun onCreateViewHolder(parent: ViewGroup): BestSellerHolder {
        return BestSellerHolder(
            parent.inflate(R.layout.item_rv_best_seller),
            favoriteChange
        )
    }

    override fun onBindViewHolder(
        item: ItemBestSellerUi,
        holder: BestSellerHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class BestSellerHolder(
        view: View,
        favoriteChange: (item: ItemBestSellerUi) -> Unit,
    ) : RecyclerView.ViewHolder(view) {

        private val binding = ItemRvBestSellerBinding.bind(view)
        private val context = view.context
        private lateinit var currentItem: ItemBestSellerUi

        init {
            binding.imageViewIsFavorite.setOnClickListener {
                favoriteChange(currentItem)
            }
        }

        fun bind(item: ItemBestSellerUi) {
            currentItem = item

            binding.textViewTitle.text = item.title
            binding.textViewDiscountPrice.text = item.discountPrice
            binding.textViewPriceWithoutDiscount.text = item.priceWithoutDiscount

            binding.imageViewIsFavorite.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    if (item.isFavorites) R.drawable.ic_favorite_true_orange
                    else R.drawable.ic_favorite_false_orange, null
                )
            )

            Glide.with(itemView)
                .load(item.picture)
                .error(R.drawable.ic_error_load_image)
                .into(binding.imageViewPicture)
        }
    }
}