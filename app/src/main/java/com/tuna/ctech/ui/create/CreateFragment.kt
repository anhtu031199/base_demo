package com.tuna.ctech.ui.create

import androidx.fragment.app.viewModels
import com.tuna.ctech.BR
import com.tuna.ctech.R
import com.tuna.ctech.base.BaseFragment
import com.tuna.ctech.databinding.FragmentCreateBinding

class CreateFragment : BaseFragment<CreateViewModel, FragmentCreateBinding>() {
    override val viewModel: CreateViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_create

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {
    }
}
