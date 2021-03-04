package org.dev.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.presentation.di.artist.ArtistSubComponent
import org.dev.tmdbclient.presentation.di.movie.MovieSubComponent
import org.dev.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}