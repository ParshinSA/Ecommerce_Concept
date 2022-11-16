package com.example.screen_explore.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.extensions.add
import com.example.screen_explore.domain.interactors.ExploreScreenInteractor
import com.example.screen_explore.presentation.models.ItemBestSellerUi
import com.example.screen_explore.presentation.models.ItemHomeStoreUi
import com.example.screen_explore.presentation.models.SelectCategory
import com.example.screen_explore.presentation.models.domain_to_ui.toItemBestSellerUi
import com.example.screen_explore.presentation.models.domain_to_ui.toItemHomeStoreUi
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewModelExploreFrg(
    interactor: ExploreScreenInteractor
) : ViewModel() {
    private val container = CompositeDisposable()
    private val selectCategory = SelectCategory.values().toList()

    private val selectCategoryMutLiveData = MutableLiveData(selectCategory)
    val selectCategoryLiveData: LiveData<List<SelectCategory>> get() = selectCategoryMutLiveData

    private val homeStoreMutLiveData = MutableLiveData<List<ItemHomeStoreUi>>()
    val homeStoreLiveData: LiveData<List<ItemHomeStoreUi>> get() = homeStoreMutLiveData

    private val bestSellerMutLiveData = MutableLiveData<List<ItemBestSellerUi>>()
    val bestSellerLiveData: LiveData<List<ItemBestSellerUi>> get() = bestSellerMutLiveData

    init {
        interactor.getExploreScreenData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ homeScreenDataDomain ->
                homeStoreMutLiveData.value =
                    homeScreenDataDomain.homeStore.map { itemHomeStoreDomain ->
                        itemHomeStoreDomain.toItemHomeStoreUi()
                    }
                bestSellerMutLiveData.value =
                    homeScreenDataDomain.bestSeller.map { itemBestSellerDomain ->
                        itemBestSellerDomain.toItemBestSellerUi()
                    }
            }, { it.printStackTrace() }).add(container)
    }

    fun changeSelectCategory(itemClicked: SelectCategory) {
        selectCategoryMutLiveData.value =
            selectCategory.map { item ->
                item.isSelected = item == itemClicked
                item
            }
    }

    fun favoriteChange(item: ItemBestSellerUi): Completable {
        return Completable.create { emitter ->
            val oldList = bestSellerLiveData.value ?: emptyList()

            bestSellerMutLiveData.value = oldList.map { itemBestSellerUi ->
                if (itemBestSellerUi == item)
                    ItemBestSellerUi(
                        id = item.id,
                        isFavorites = !item.isFavorites,
                        title = item.title,
                        priceWithoutDiscount = item.priceWithoutDiscount,
                        discountPrice = item.discountPrice,
                        picture = item.picture,
                    )
                else itemBestSellerUi
            }

            emitter.onComplete()
        }

    }

    override fun onCleared() {
        container.clear()
        super.onCleared()
    }
}