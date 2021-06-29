package com.example.moviesapi.data.repository

import com.example.moviesapi.data.api.MovieApi
import com.example.moviesapi.data.api.RetrofitInstance
import com.example.moviesapi.data.model.Genre
import com.example.moviesapi.data.model.Movie
import com.example.moviesapi.data.model.MovieResponse
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class MovieRepositoryImplTest {
//    val api = mockk<MovieApi>()
//    val repository = MovieRepositoryImpl(api)
//    val genres = ArrayList<Genre>(listOf(
//            Genre(
//                    id = 1,
//                    name = "Horror"
//            ),
//            Genre(
//                    id = 2,
//                    name = "Action"
//            ))
//    )
//    val movie = Movie(
//            1,
//            genres,
//            "Pilot",
//            "Test movie",
//            1222,
//            LocalDate.parse("2020-04-01"),
//            2.2,
//            1
//    )
//    val movie2 = movie.copy(id = 2, original_title = "Pilot 2")
//
//    val movies = ArrayList<Movie>(listOf(
//            movie,
//            movie2
//    ))
//
//    val moviesReponse = ArrayList<MovieResponse>(listOf(
//            MovieResponse(
//                    1,
//                    ArrayList<Long>(emptyList())),
//            MovieResponse(
//                    2,
//                    ArrayList<Long>(emptyList()))
//    )
//    )
//
//    @Test
//    fun shouldReturnExpectedMoviesByMoviesResponseId() = runBlocking {
//        coEvery { api.getMovieById(id = 1) } returns movie
//        coEvery { api.getMovieById(id = 2) } returns movie2
//
//        assertEquals(movies, repository.getMoviesByMoviesResponseId(moviesReponse))
//    }
//
//    @Test
//    fun shouldNotReturnExpectedMoviesByMoviesResponseId() = runBlocking {
//        coEvery { api.getMovieById(id = 1) } returns movie
//        coEvery { api.getMovieById(id = 2) } returns movie
//
//        assertNotEquals(movies, repository.getMoviesByMoviesResponseId(moviesReponse))
//    }
//
//    @Test
//    fun shouldReturnEmptyListWhenIdNotExists() = runBlocking {
//        coEvery { api.getMovieById(id = any()) } returns null
//
//        assertEquals(ArrayList<Movie>(), repository.getMoviesByMoviesResponseId(moviesReponse))
//    }
}