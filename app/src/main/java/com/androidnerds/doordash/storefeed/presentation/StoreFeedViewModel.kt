package com.androidnerds.doordash.storefeed.presentation

import androidx.lifecycle.ViewModel
import com.androidnerds.doordash.storefeed.domain.usecase.GetStoreFeedUseCase
import javax.inject.Inject

class StoreFeedViewModel @Inject constructor(
    private val getStoreFeedUseCase: GetStoreFeedUseCase
): ViewModel() {
    // TODO: Implement the ViewModel
}