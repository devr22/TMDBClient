package org.dev.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.data.api.TMDBService
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import org.dev.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import org.dev.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import org.dev.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
}