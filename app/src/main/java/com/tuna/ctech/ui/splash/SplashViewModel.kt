package com.tuna.ctech.ui.splash

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.tuna.ctech.base.BaseViewModel
import com.tuna.ctech.navigation.NavigationCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    app: Application,
) : BaseViewModel(app) {
    fun navigateToHome() {
        viewModelScope.launch {
            delay(1000L)
            navigate(
                NavigationCommand.To(
                    SplashFragmentDirections.actionSplashFragmentToHomeFragment(),
                ),
            )
        }
    }
}
