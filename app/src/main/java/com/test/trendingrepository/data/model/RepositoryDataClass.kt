package com.test.trendingrepository.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class RepositoryDataItem(
    val uid: Int,
    val author: String,
    val avatar: String,
    val builtBy: List<BuiltBy>?,
    val currentPeriodStars: Int,
    val description: String,
    val forks: Int,
    val language: String,
    val languageColor: String,
    val name: String,
    val stars: Int,
    val url: String
)

data class BuiltBy(
    val avatar: String,
    val href: String,
    val username: String
)


@Entity(tableName = "repository_table")
data class OfflineRepositoryDataItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo(name = "author_name") val author: String,
    @ColumnInfo(name = "repo_description") val description: String,
    @ColumnInfo(name = "language") val language: String,
    @ColumnInfo(name = "language_colour") val languageColor: String,
    @ColumnInfo(name = "repository_name") val name: String,
    @ColumnInfo(name = "no_of_stars")val stars: Int,
){

}