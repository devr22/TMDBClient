package org.dev.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.dev.tmdbclient.data.model.tvShow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("delete from popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("select * from popular_tvShows")
    suspend fun getTvShows(): List<TvShow>

}