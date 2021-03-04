package org.dev.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.dev.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("delete from popular_movies")
    suspend fun deleteAllMovies()

    @Query("select * from popular_movies")
    suspend fun getMovies(): List<Movie>

}