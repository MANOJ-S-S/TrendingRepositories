package com.test.trendingrepository.data.api


import com.test.trendingrepository.data.model.RepositoryDataItem
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiService {

    @GET("/repositories")
    fun getRepositories(): Observable<List<RepositoryDataItem>>

}