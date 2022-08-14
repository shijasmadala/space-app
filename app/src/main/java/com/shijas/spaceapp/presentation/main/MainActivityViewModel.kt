package com.shijas.spaceapp.presentation.main

import androidx.lifecycle.ViewModel
import com.shijas.spaceapp.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {
    val nasaData = homeRepository.getNasaData().sortedByDescending { it.date }

    var selectedIndex = 0

}