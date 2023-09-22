package com.tuna.ctech.ui.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.tuna.ctech.BR
import com.tuna.ctech.R
import com.tuna.ctech.base.BaseFragment
import com.tuna.ctech.data.remote.response.Hourly
import com.tuna.ctech.databinding.FragmentHomeBinding
import com.tuna.ctech.extensions.orDefault
import com.tuna.ctech.extensions.setOnSingleClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(),
    HomeViewModel.HourlyCallback {
    override val viewModel: HomeViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        viewModel.hourlyCallback = this@HomeFragment
        binding.btnSearch.setOnSingleClickListener {
            viewModel.getDataWithName(binding.etSearchEmployee.text.toString())
        }
    }

    override fun initData() {
        viewModel.getData()
        viewModel.showErrorDialog.observeSingle(viewLifecycleOwner) {
            if (it) {
                showErrorDialog(
                    message = viewModel.errorMessage.value.orDefault(),
                    positiveButton = "Retry",
                    onPositive = {
                        viewModel.getData()
                    },
                )
            } else {
                hideDialog()
            }
        }
    }

    override fun onHourlyItemClick(item: Hourly) {
        viewModel.navigateToDetail(item)
    }
}
