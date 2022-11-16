package com.example.screen_explore.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.presentation.adapters.AppRecyclerViewAdapter
import com.example.common.presentation.interfaces.DisplayableItem
import com.example.screen_explore.common.di.settings.ExploreComponentViewModel
import com.example.screen_explore.databinding.FragmentExploreBinding
import com.example.screen_explore.presentation.adapters.ItemBestSellerAdapterDelegate
import com.example.screen_explore.presentation.adapters.ItemHomeStoreAdapterDelegate
import com.example.screen_explore.presentation.adapters.ItemSelectCategoryAdapterDelegate
import com.example.screen_explore.presentation.viewmodels.ViewModelExploreFrg
import com.example.screen_explore.presentation.viewmodels.ViewModelFactory
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import javax.inject.Inject

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = checkNotNull(_binding)

    private val componentViewModel: ExploreComponentViewModel by viewModels()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ViewModelExploreFrg by viewModels { viewModelFactory }

    private val adapterBestSellerRv by lazy {
        createAdapter(AdapterDelegatesManager(ItemBestSellerAdapterDelegate { item ->
            viewModel.favoriteChange(item).subscribe()
        }))
    }

    private val adapterSelectCategoryRv by lazy {
        createAdapter(
            AdapterDelegatesManager(
                ItemSelectCategoryAdapterDelegate { item ->
                    viewModel.changeSelectCategory(item)
                }
            )
        )
    }

    //    \/\/Только жизненый цикл\/\/
    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action()
    }
    //    /\/\Только жизненый цикл/\/\

    private fun action() {
        initRvBestSeller()
        initSelectCategory()
        filterMenuListener()
        observeData()
    }

    private fun createAdapter(delegatesManager: AdapterDelegatesManager<List<DisplayableItem>>)
            : AsyncListDifferDelegationAdapter<DisplayableItem> {
        return AsyncListDifferDelegationAdapter(
            AppRecyclerViewAdapter.DiffUtilItemCallback(),
            delegatesManager
        )
    }

    private fun filterMenuListener() {
        binding.imageViewFilterMenu.setOnClickListener {
            val btmSheetFragment = BtmSheetFragment.newInstance()
            btmSheetFragment.show(childFragmentManager, btmSheetFragment.tag)
        }
    }

    private fun initSelectCategory() {
        with(binding.recyclerViewSelectCategory) {
            adapter = adapterSelectCategoryRv
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initRvBestSeller() {
        with(binding.recyclerViewBestSeller) {
            adapter = adapterBestSellerRv
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
    }

    private fun observeData() {
        viewModel.bestSellerLiveData.observe(viewLifecycleOwner) { listBestSeller ->
            adapterBestSellerRv.items = listBestSeller
        }

        viewModel.homeStoreLiveData.observe(viewLifecycleOwner) { listHomeStore ->
            binding.viewPager2HotSales.adapter = ItemHomeStoreAdapterDelegate(this, listHomeStore)
        }

        viewModel.selectCategoryLiveData.observe(viewLifecycleOwner) { listSelectCategory ->
            adapterSelectCategoryRv.items = listSelectCategory
            adapterSelectCategoryRv.notifyDataSetChanged()
        }
    }


    private fun inject() {
        componentViewModel.component.inject(this)
    }

    companion object {
        fun newInstance() = ExploreFragment()
    }

}