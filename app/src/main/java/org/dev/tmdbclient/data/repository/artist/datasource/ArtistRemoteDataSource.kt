package org.dev.tmdbclient.data.repository.artist.datasource

import org.dev.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}