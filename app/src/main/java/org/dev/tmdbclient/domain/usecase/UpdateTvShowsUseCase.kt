package org.dev.tmdbclient.domain.usecase

import org.dev.tmdbclient.data.model.tvShow.TvShow
import org.dev.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}