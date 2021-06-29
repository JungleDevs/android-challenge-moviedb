package com.example.moviesapi.data.model

data class Response (
    val page: Int,
    val results: ArrayList<MovieResponse>
) {
}