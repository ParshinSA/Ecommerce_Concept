package com.example.container_fragment.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.common.presentation.interfaces.BackButtonListener
import com.example.container_fragment.R
import com.example.container_fragment.databinding.FragmentContainerBinding
import com.example.container_fragment.di.FragmentContainerComponentViewModel
import com.example.container_fragment.di.dependencies.nested.ScreensContainerFragment
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject

class ContainerFragment : Fragment(), BackButtonListener {

    private val componentViewModel: FragmentContainerComponentViewModel by viewModels()

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var screen: ScreensContainerFragment

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val fragmentManger by lazy { childFragmentManager }

    @IdRes
    private val idContainer = R.id.fragmentContainer

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), idContainer, fragmentManger)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        componentViewModel.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
        action()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun action() {
        openStartFragment()
        listenerTabLayoutBottomNavMenu()
    }

    private fun listenerTabLayoutBottomNavMenu() {
        binding.tabLayoutBottomNavMenu.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab == null) return
                openFragment(tab.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun openFragment(menuItemId: String) {
        var currentFragment: Fragment? = null
        val transaction = fragmentManger.beginTransaction()
        val nextFragment = fragmentManger.findFragmentByTag(menuItemId)

        for (fragment in fragmentManger.fragments) {
            if (fragment.isVisible) {
                currentFragment = fragment
            }
        }

        if (currentFragment != null && currentFragment === nextFragment) return

        if (nextFragment == null) {
            val getNewFragment = getFragment(menuItemId) ?: return
            transaction.add(R.id.fragmentContainer, getNewFragment, menuItemId)
        }

        currentFragment?.let { transaction.hide(it) }
        nextFragment?.let { transaction.show(it) }
        transaction.commitNow()
    }

    private fun openStartFragment() {
        openFragment(resources.getString(R.string.itemExplore))
    }

    private fun getFragment(menuItemId: String): Fragment? {

        val fragmentScreen = try {
            when (menuItemId) {
                resources.getString(R.string.itemExplore) -> screen.ExploreFrg()
                resources.getString(R.string.itemCart) -> screen.MyCartFrg()
                resources.getString(R.string.itemFavorite) -> null
                resources.getString(R.string.itemProfile) -> null
                else -> {
                    error("Unknown menu item id $menuItemId")
                }
            }
        } catch (t: Throwable) {
            t.printStackTrace()
            null
        }
        return fragmentScreen?.createFragment(fragmentManger.fragmentFactory)
    }

    companion object {
        fun newInstance() = ContainerFragment()
    }

    override fun onBackPressed(): Boolean {
        return childFrgIsBackBtnListener()
    }


    private fun childFrgIsBackBtnListener(): Boolean {
        val currentFragment = childFragmentManager.findFragmentById(idContainer) ?: return false
        return currentFragment is BackButtonListener && currentFragment.onBackPressed()
    }
}