package org.dev.tmdbclient.domain.usecase

import org.dev.tmdbclient.data.model.movie.Movie
import org.dev.tmdbclient.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}