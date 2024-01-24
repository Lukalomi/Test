package com.example.playground.data.remote.network.services

import com.example.playground.data.remote.models.ColorInfoItem
import retrofit2.Response
import retrofit2.http.GET

interface ColorsService {

    @GET("colors/new?format=json")
    suspend fun getColors(): Response<List<ColorInfoItem>>
}