package com.tuna.ctech.ui.detail

import android.app.Application
import com.tuna.ctech.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(app: Application) : BaseViewModel(app)
