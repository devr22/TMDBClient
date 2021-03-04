package org.dev.tmdbclient.data.repository.tvShow.datasource

import org.dev.tmdbclient.data.model.tvShow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}