package com.tuna.ctech.ui.detail

import androidx.fragment.app.viewModels
import com.tuna.ctech.BR
import com.tuna.ctech.R
import com.tuna.ctech.base.BaseFragment
import com.tuna.ctech.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailsBinding>() {
    override val viewModel: DetailViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_details

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {
    }
}
