package com.tuna.ctech.ui.create

import android.app.Application
import com.tuna.ctech.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(app: Application) : BaseViewModel(app)
