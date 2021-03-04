package org.dev.tmdbclient.data.repository.movie.datasourceImpl

import org.dev.tmdbclient.data.api.TMDBService
import org.dev.tmdbclient.data.model.movie.MovieList
import org.dev.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}