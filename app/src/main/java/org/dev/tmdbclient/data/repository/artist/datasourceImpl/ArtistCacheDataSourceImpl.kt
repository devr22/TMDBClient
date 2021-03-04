package org.dev.tmdbclient.data.repository.artist.datasourceImpl

import org.dev.tmdbclient.data.model.artist.Artist
import org.dev.tmdbclient.data.model.movie.Movie
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import org.dev.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}