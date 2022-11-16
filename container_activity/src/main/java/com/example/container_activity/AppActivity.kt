package com.example.container_activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.common.presentation.interfaces.BackButtonListener
import com.example.container_activity.di.ActivityContainerComponentViewModel
import com.example.container_activity.di.dependencies.nested.ActivityRouterProvider
import com.example.container_activity.di.dependencies.nested.ScreensContainerActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class AppActivity : AppCompatActivity() {

    @Inject
    lateinit var screen: ScreensContainerActivity

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var routerProvider: ActivityRouterProvider

    private val idContainer = R.id.activityContainerFragment
    private val navigator: Navigator = AppNavigator(this, idContainer)

    private val componentViewModel: ActivityContainerComponentViewModel by viewModels()

    //    \/\/Только жизненый цикл\/\/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        inject()
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
    //    /\/\Только жизненый цикл/\/\

    private fun action() {
        routerProvider.router.navigateTo(screen.ContainerFrgNavMenu())
    }

    private fun inject() {
        componentViewModel.component.inject(this)
    }

    override fun onBackPressed() {
        if (!childFrgIsBackBtnListener()) this.finish()
    }

    private fun childFrgIsBackBtnListener(): Boolean {
        val currentFragment = supportFragmentManager.findFragmentById(idContainer) ?: return false
        return currentFragment is BackButtonListener && currentFragment.onBackPressed()
    }
}