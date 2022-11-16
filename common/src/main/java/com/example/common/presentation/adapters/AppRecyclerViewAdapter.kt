package com.example.common.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.common.presentation.interfaces.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class AppRecyclerViewAdapter :
    AsyncListDifferDelegationAdapter<DisplayableItem>(DiffUtilItemCallback()) {

    class DiffUtilItemCallback : DiffUtil.ItemCallback<DisplayableItem>() {

        override fun areItemsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean {
            return oldItem.itemHashCode == newItem.itemHashCode
        }

        override fun areContentsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem) =
            oldItem.hashCode() == newItem.hashCode()
    }
}