package org.dev.tmdbclient.data.repository.artist

import android.util.Log
import org.dev.tmdbclient.data.model.artist.Artist
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import org.dev.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import org.dev.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null)
                artistList = body.artists
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return if (artistList.isNotEmpty())
            artistList
        else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
            artistList
        }
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return if (artistList.isNotEmpty())
            artistList
        else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
            artistList
        }
    }

}