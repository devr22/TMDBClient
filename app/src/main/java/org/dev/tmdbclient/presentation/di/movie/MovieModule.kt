package org.dev.tmdbclient.presentation.di.movie

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.domain.usecase.GetMovieUseCase
import org.dev.tmdbclient.domain.usecase.UpdateMovieUseCase
import org.dev.tmdbclient.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}