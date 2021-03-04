package org.dev.tmdbclient.presentation

import android.app.Application
import org.dev.tmdbclient.BuildConfig
import org.dev.tmdbclient.presentation.di.Injector
import org.dev.tmdbclient.presentation.di.artist.ArtistSubComponent
import org.dev.tmdbclient.presentation.di.core.*
import org.dev.tmdbclient.presentation.di.movie.MovieSubComponent
import org.dev.tmdbclient.presentation.di.tvShow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}