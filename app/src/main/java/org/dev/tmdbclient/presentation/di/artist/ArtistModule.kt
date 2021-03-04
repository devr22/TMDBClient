package org.dev.tmdbclient.presentation.di.artist

import dagger.Module
import dagger.Provides
import org.dev.tmdbclient.domain.usecase.GetArtistsUseCase
import org.dev.tmdbclient.domain.usecase.UpdateArtistsUseCase
import org.dev.tmdbclient.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}