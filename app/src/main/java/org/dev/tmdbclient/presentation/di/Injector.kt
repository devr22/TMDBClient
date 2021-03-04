package org.dev.tmdbclient.presentation.di

import org.dev.tmdbclient.presentation.di.artist.ArtistSubComponent
import org.dev.tmdbclient.presentation.di.movie.MovieSubComponent
import org.dev.tmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}