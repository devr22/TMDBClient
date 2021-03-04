package org.dev.tmdbclient.data.repository.artist.datasourceImpl

import org.dev.tmdbclient.data.api.TMDBService
import org.dev.tmdbclient.data.model.artist.ArtistList
import org.dev.tmdbclient.data.model.movie.MovieList
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import org.dev.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}