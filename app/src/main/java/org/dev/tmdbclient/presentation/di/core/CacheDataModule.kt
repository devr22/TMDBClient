package org.dev.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import org.dev.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import org.dev.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import org.dev.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}