package com.tuna.ctech.ui.splash

import androidx.fragment.app.viewModels
import com.tuna.ctech.BR
import com.tuna.ctech.R
import com.tuna.ctech.base.BaseFragment
import com.tuna.ctech.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {
    override val viewModel: SplashViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {
        viewModel.navigateToHome()
    }
}
