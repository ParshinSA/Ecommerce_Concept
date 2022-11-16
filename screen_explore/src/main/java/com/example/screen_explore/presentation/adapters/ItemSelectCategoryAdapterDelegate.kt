package com.example.screen_explore.presentation.adapters

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.common.extensions.inflate
import com.example.common.presentation.interfaces.DisplayableItem
import com.example.screen_explore.R
import com.example.screen_explore.databinding.ItemRvSelectCategoryBinding
import com.example.screen_explore.presentation.models.SelectCategory
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ItemSelectCategoryAdapterDelegate(
    private val itemClick: (item: SelectCategory) -> Unit,
) :
    AbsListItemAdapterDelegate<SelectCategory, DisplayableItem, ItemSelectCategoryAdapterDelegate.ItemSelectCategoryViewHolder>() {

    override fun isForViewType(
        item: DisplayableItem,
        items: MutableList<DisplayableItem>,
        position: Int
    ) = item is SelectCategory

    override fun onCreateViewHolder(parent: ViewGroup) =
        ItemSelectCategoryViewHolder(parent.inflate(R.layout.item_rv_select_category), itemClick)

    override fun onBindViewHolder(
        item: SelectCategory,
        holder: ItemSelectCategoryViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class ItemSelectCategoryViewHolder(
        view: View,
        itemClick: (item: SelectCategory) -> Unit,
    ) : RecyclerView.ViewHolder(view) {

        private val binding = ItemRvSelectCategoryBinding.bind(view)
        private val context = view.context
        private lateinit var currentItem: SelectCategory

        init {
            binding.imageButton.setOnClickListener { itemClick(currentItem) }
        }

        fun bind(item: SelectCategory) {
            currentItem = item

            binding.textViewTitleSelectCategory.text = item.title

            if (item.isSelected) {
                binding.imageButton.background = getDraw(R.drawable.ic_ellipse_orange)
                binding.imageButton.setImageDrawable(getDraw(item.selectIcon))
                binding.textViewTitleSelectCategory.setTextColor(getColor(R.color.colorTextOrange))
            } else {
                binding.imageButton.background = getDraw(R.drawable.ic_ellipse_white)
                binding.imageButton.setImageDrawable(getDraw(item.unselectIcon))
                binding.textViewTitleSelectCategory.setTextColor(getColor(R.color.colorTextDarkBlue))
            }
        }

        private fun getDraw(@DrawableRes id: Int): Drawable {
            return checkNotNull(ResourcesCompat.getDrawable(context.resources, id, null))
        }

        private fun getColor(@ColorRes id: Int): Int {
            return checkNotNull(context.resources.getColor(id, null))
        }
    }
}
