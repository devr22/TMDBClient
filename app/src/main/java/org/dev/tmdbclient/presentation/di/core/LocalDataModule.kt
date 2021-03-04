package org.dev.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.data.db.ArtistDao
import org.dev.tmdbclient.data.db.MovieDao
import org.dev.tmdbclient.data.db.TvShowDao
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import org.dev.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import org.dev.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import org.dev.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}