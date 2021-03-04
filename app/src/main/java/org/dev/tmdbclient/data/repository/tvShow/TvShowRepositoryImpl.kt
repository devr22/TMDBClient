package org.dev.tmdbclient.data.repository.tvShow

import android.util.Log
import org.dev.tmdbclient.data.model.tvShow.TvShow
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import org.dev.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null)
                tvShowList = body.tvShows
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return if (tvShowList.isNotEmpty())
            tvShowList
        else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
            tvShowList
        }
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return if (tvShowList.isNotEmpty())
            tvShowList
        else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
            tvShowList
        }
    }
}