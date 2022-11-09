package com.example.screen_home.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.screen_home.domain.interactors.HomeScreenInteractor
import com.example.screen_home.domain.models.ItemBestSellerDomain
import com.example.screen_home.domain.models.ItemHomeStoreDomain
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewModelHomeFrg(
    interactor: HomeScreenInteractor
) : ViewModel() {
    private val container = CompositeDisposable()

    private val homeStoreMutLiveData = MutableLiveData<List<ItemHomeStoreDomain>>()
    val homeStoreLiveData: LiveData<List<ItemHomeStoreDomain>> get() = homeStoreMutLiveData

    private val bestSellerMutLiveData = MutableLiveData<List<ItemBestSellerDomain>>()
    val bestSellerLiveData: LiveData<List<ItemBestSellerDomain>> get() = bestSellerMutLiveData

    init {
        container.add(
            interactor.getHomeScreenData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ homeScreenDataDomain ->
                    homeStoreMutLiveData.value = homeScreenDataDomain.homeStore
                    bestSellerMutLiveData.value = homeScreenDataDomain.bestSeller
                }, { it.printStackTrace() })
        )
    }

    override fun onCleared() {
        container.clear()
        super.onCleared()
    }
}