package org.dev.tmdbclient.domain.usecase

import org.dev.tmdbclient.data.model.artist.Artist
import org.dev.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}