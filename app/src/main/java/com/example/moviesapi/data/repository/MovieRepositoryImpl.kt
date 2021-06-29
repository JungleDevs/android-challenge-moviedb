package com.example.moviesapi.data.repository

import com.example.moviesapi.data.api.MovieApi
import com.example.moviesapi.data.error.GeneralErrorHandlerImpl
import com.example.moviesapi.data.model.Movie
import com.example.moviesapi.data.model.MovieResponse
import com.example.moviesapi.domain.repository.MovieRepository
import com.example.moviesapi.data.model.Result

class MovieRepositoryImpl(
    val api: MovieApi,
    val errorHandler: GeneralErrorHandlerImpl
) : MovieRepository {
    override suspend fun getMovies(page: Int): Result<ArrayList<Movie>> {
        return try {
            getMoviesByMoviesResponseId(api.getPopularMovies(page = page).body()!!.results)
        } catch (t: Throwable) {
            Result.Error(errorHandler.getError(t))
        }
    }


    override suspend fun searchMovie(query: String, page: Int): Result<ArrayList<Movie>> {
        return try {
            getMoviesByMoviesResponseId(
                api.searchMovie(query = query, page = page).body()!!.results
            )
        } catch (t: Throwable) {
            Result.Error(errorHandler.getError(t))
        }

    }

    suspend fun getMoviesByMoviesResponseId(moviesResponse: ArrayList<MovieResponse>?): Result<ArrayList<Movie>> {
        val movies = ArrayList<Movie>()
        moviesResponse?.forEach { movieResponse ->
            try {
                val response = api.getMovieById(movieResponse.id)
                response.body()?.let {
                    movies.add(it)
                }
            } catch (t: Throwable) {
                return Result.Error(errorHandler.getError(t))
            }
        }
        return Result.Success(movies)
    }
}