package org.dev.tmdbclient.domain.repository

import org.dev.tmdbclient.data.model.tvShow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}