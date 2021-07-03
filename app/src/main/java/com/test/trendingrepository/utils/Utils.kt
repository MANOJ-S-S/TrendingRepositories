package com.test.trendingrepository.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

object Utils {

     const val BASE_URL = "https://private-anon-fa9fd817d2-githubtrendingapi.apiary-mock.com"

     @RequiresApi(Build.VERSION_CODES.M)

     fun isNetworkAvailable(context: Context?):Boolean{

          val manager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
          val capabilities = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
               manager?.getNetworkCapabilities(manager.activeNetwork)
          } else {
               TODO("VERSION.SDK_INT < LOLLIPOP")
          }
          if(capabilities != null) {
               return (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) || capabilities.hasTransport(
                       NetworkCapabilities.TRANSPORT_CELLULAR)
                       || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
          }
          return false
     }

}

