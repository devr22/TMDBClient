package org.dev.tmdbclient.presentation.di.tvShow

import dagger.Subcomponent
import org.dev.tmdbclient.presentation.tvShow.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}