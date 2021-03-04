package org.dev.tmdbclient.data.repository.movie.datasource

import org.dev.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}