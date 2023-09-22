package com.tuna.ctech.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tuna.ctech.navigation.NavigationCommand
import com.tuna.ctech.navigation.Navigator
import com.tuna.nothingapp.utils.SingleLiveEvent

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {
    val navigateEvent by lazy { SingleLiveEvent<NavigationCommand>() }

    private lateinit var _navigator: Navigator
    val navigator get() = _navigator

    fun setNavigator(navigator: Navigator) {
        _navigator = navigator
    }

    fun navigateBack() {
        navigate(NavigationCommand.Back)
    }

    fun navigate(navigationCommand: NavigationCommand) {
        navigateEvent.value = navigationCommand
    }
}
