package com.test.trendingrepository.data.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.trendingrepository.data.model.OfflineRepositoryDataItem



@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg repos: OfflineRepositoryDataItem)

    @Query("SELECT * FROM repository_table")
    fun getAll(): List<OfflineRepositoryDataItem>

    @Query("DELETE FROM repository_table")
    fun nukeTable()

}