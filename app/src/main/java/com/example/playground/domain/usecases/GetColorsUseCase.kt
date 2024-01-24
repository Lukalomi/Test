package com.example.playground.domain.usecases

import com.example.playground.core.ResponseStatus
import com.example.playground.data.remote.models.ColorInfoItem
import com.example.playground.data.remote.repository_impl.ColorsRepositoryImpl
import javax.inject.Inject

class GetColorsUseCase @Inject constructor(private val colorsRepositoryImpl: ColorsRepositoryImpl) {

    suspend fun getColors(): ResponseStatus<List<ColorInfoItem>> {
        return try {
            val response = colorsRepositoryImpl.getColors()

            if (response.isSuccessful) {
                val body = response.body() ?: emptyList()
                ResponseStatus.Success(body)
            } else {
                val errorMessage = "Failed to fetch colors. Response Code: ${response.code()}"
                ResponseStatus.Fail(errorMessage)
            }
        } catch (e: Exception) {
            val errorMessage = "Error fetching colors: ${e.message}"
            ResponseStatus.Fail(errorMessage)
        }
    }

}