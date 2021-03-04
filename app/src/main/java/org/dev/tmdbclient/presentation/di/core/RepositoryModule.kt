package org.dev.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import org.dev.tmdbclient.data.repository.movie.MovieRepositoryImpl
import org.dev.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import org.dev.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import org.dev.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import org.dev.tmdbclient.data.repository.tvShow.TvShowRepositoryImpl
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDataSource
import org.dev.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import org.dev.tmdbclient.domain.repository.ArtistRepository
import org.dev.tmdbclient.domain.repository.MovieRepository
import org.dev.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}