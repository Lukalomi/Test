package com.example.playground.domain.repositories

import com.example.playground.data.remote.models.ColorInfoItem
import retrofit2.Response

interface ColorsRepository {
    suspend fun getColors(): Response<List<ColorInfoItem>>
}