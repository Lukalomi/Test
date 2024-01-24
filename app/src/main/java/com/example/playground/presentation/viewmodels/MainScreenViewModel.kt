package com.example.playground.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playground.core.ResponseStatus
import com.example.playground.data.remote.models.ColorInfoItem
import com.example.playground.domain.usecases.GetColorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(private val getColorsUseCase: GetColorsUseCase) :
    ViewModel() {

    private val _colors =
        MutableStateFlow<ResponseStatus<List<ColorInfoItem>>>(ResponseStatus.Loading)

    val colors: StateFlow<ResponseStatus<List<ColorInfoItem>>> get() = _colors

     fun fetchColors() {
        viewModelScope.launch {
            _colors.value = getColorsUseCase.getColors()
        }
    }
}