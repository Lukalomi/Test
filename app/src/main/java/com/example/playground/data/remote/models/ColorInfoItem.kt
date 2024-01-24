package com.example.playground.data.remote.models

import com.squareup.moshi.Json

data class ColorInfoItem(
    @Json(name = "id")
    val id: Long,
    @Json(name = "title")
    val title: String,
    @Json(name = "userName")
    val userName: String,
    @Json(name = "numViews")
    val numViews: Int,
    @Json(name = "numVotes")
    val numVotes: Int,
    @Json(name = "numComments")
    val numComments: Int,
    @Json(name = "numHearts")
    val numHearts: Int,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "dateCreated")
    val dateCreated: String,
    @Json(name = "hex")
    val hex: String,
    @Json(name = "rgb")
    val rgb: RGB,
    @Json(name = "hsv")
    val hsv: HSV,
    @Json(name = "description")
    val description: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "badgeUrl")
    val badgeUrl: String,
    @Json(name = "apiUrl")
    val apiUrl: String
)

data class RGB(
    @Json(name = "red")
    val red: Int,
    @Json(name = "green")
    val green: Int,
    @Json(name = "blue")
    val blue: Int
)

data class HSV(
    @Json(name = "hue")
    val hue: Int,
    @Json(name = "saturation")
    val saturation: Int,
    @Json(name = "value")
    val value: Int
)
