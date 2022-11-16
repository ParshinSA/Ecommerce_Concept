package com.example.screen_explore.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.common.extensions.withArguments
import com.example.screen_explore.databinding.ItemVpHotSalesBinding
import com.example.screen_explore.presentation.models.ItemHomeStoreUi

class ItemHotSalesFragment : Fragment() {

    private var _binding: ItemVpHotSalesBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemVpHotSalesBinding.inflate(inflater, container, false)
        setData()
        return binding.root
    }

    private fun setData() {
        val item: ItemHomeStoreUi = requireArguments().getParcelable(KEY_ITEM) ?: return

        binding.textViewIsNew.isVisible = item.isNew
        binding.textViewTitle.text = item.title
        binding.textViewSubtitle.text = item.subtitle
        binding.apcButtonBuyNow.isEnabled = item.isBuy

        Glide.with(requireContext())
            .load(item.picture)
            .into(binding.imageViewPicture)
    }

    companion object {
        private const val KEY_ITEM = "key item"

        fun newInstance(item: ItemHomeStoreUi) = ItemHotSalesFragment().withArguments {
            putParcelable(KEY_ITEM, item)
        }
    }
}