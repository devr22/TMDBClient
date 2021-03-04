package org.dev.tmdbclient.data.repository.tvShow.datasource

import org.dev.tmdbclient.data.model.tvShow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}