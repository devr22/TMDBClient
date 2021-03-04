package org.dev.tmdbclient.presentation.di.core

import dagger.Component
import org.dev.tmdbclient.presentation.di.artist.ArtistSubComponent
import org.dev.tmdbclient.presentation.di.movie.MovieSubComponent
import org.dev.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}