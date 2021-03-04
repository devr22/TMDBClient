package org.dev.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import org.dev.tmdbclient.domain.usecase.GetMovieUseCase
import org.dev.tmdbclient.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute();
        emit(movieList)
    }

}