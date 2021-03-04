package org.dev.tmdbclient.data.repository.tvShow.datasource

import org.dev.tmdbclient.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}