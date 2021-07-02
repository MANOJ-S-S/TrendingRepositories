package com.test.trendingrepository.data.api

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.test.trendingrepository.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {

    private lateinit var apiService: ApiService


      fun getInstance(context: Context, baseUrl : String) : ApiService {

          /* OKHttpClient builder */

        val builder = OkHttpClient().newBuilder()
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BASIC
            builder.addInterceptor(interceptor)
        }
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        val cache = Cache(context.cacheDir, cacheSize.toLong())
        builder.cache(cache)

          /* Retrofit builder */

          val retrofit = Retrofit.Builder()
                  .client(builder.build())     /* OKHttpClient builder  is used for logging the api details in logcat */
                  .baseUrl(baseUrl)
                  .addConverterFactory(GsonConverterFactory.create())
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) /* CallAdapterFactory is used for RXJava support */
                  .build()
          apiService = retrofit.create(ApiService::class.java)
          return apiService
    }

}