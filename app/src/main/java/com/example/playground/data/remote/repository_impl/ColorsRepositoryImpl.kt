package com.example.playground.data.remote.repository_impl

import com.example.playground.data.remote.models.ColorInfoItem
import com.example.playground.data.remote.network.services.ColorsService
import com.example.playground.domain.repositories.ColorsRepository
import retrofit2.Response
import javax.inject.Inject

class ColorsRepositoryImpl @Inject constructor(private val colorsService: ColorsService) :
    ColorsRepository {

    override suspend fun getColors(): Response<List<ColorInfoItem>> {
        return colorsService.getColors()
    }
}