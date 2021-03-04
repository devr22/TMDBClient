package org.dev.tmdbclient.data.repository.tvShow.datasourceImpl

import org.dev.tmdbclient.data.api.TMDBService
import org.dev.tmdbclient.data.model.tvShow.TvShowList
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}