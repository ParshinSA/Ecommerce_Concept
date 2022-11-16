package com.example.screen_explore.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.screen_explore.presentation.fragments.ItemHotSalesFragment
import com.example.screen_explore.presentation.models.ItemHomeStoreUi

class ItemHomeStoreAdapterDelegate(
    parent: Fragment,
    private val itemList: List<ItemHomeStoreUi>
) : FragmentStateAdapter(parent) {
    override fun getItemCount() = itemList.size

    override fun createFragment(position: Int) =
        ItemHotSalesFragment.newInstance(itemList[position])

}