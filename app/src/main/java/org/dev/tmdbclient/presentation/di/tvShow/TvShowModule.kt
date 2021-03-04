package org.dev.tmdbclient.presentation.di.tvShow

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.domain.usecase.GetTvShowsUseCase
import org.dev.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import org.dev.tmdbclient.presentation.tvShow.TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}