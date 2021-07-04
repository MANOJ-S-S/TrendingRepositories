package com.test.trendingrepository.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.test.trendingrepository.R
import com.test.trendingrepository.data.api.RetrofitBuilder
import com.test.trendingrepository.data.model.OfflineRepositoryDataItem
import com.test.trendingrepository.data.model.RepositoryDataItem
import com.test.trendingrepository.data.offline.AppDatabase
import com.test.trendingrepository.data.offline.RepositoryDao
import com.test.trendingrepository.ui.main.viewmodel.RepositoryListViewModel
import com.test.trendingrepository.utils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


class MainRepository {

    companion object {

        private var mainRepository: MainRepository? = null
        private lateinit var db : AppDatabase
        private lateinit var repoDao : RepositoryDao

        fun instance(): MainRepository {
            if (mainRepository == null) synchronized(MainRepository) {
                mainRepository = MainRepository()
            }
            return mainRepository!!
        }
    }

    /* Returns the disposable from rx java */

   fun getAllRepositories(viewModel: RepositoryListViewModel, context: Context) : Disposable {
       viewModel.progressValue.postValue(true)
       //for storing offline
       db = AppDatabase.invoke(context)
       repoDao = db.repoDao()


       return RetrofitBuilder.getInstance(context, Utils.BASE_URL)
           .getRepositories()
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())
           .subscribe({ list ->
               viewModel.progressValue.postValue(false)
               viewModel.repositoryList.postValue(list)
               insertIntoDb(list,context)

           }, {
               viewModel.progressValue.postValue(false)
               viewModel.errorResponse.postValue(it.message)
           })
   }

    private fun insertIntoDb(list: List<RepositoryDataItem>?, context: Context) {

        Thread{
            repoDao.nukeTable()
            list!!.forEach {

                try {
                    repoDao.insertAll(OfflineRepositoryDataItem(author = it.author,description = it.description,
                        language = it.language, languageColor = it.languageColor, name = it.name, stars = it.stars))
                }
                catch (e : Exception){
                    Log.i("Insertion failed", e.toString())
                }
            }
        }.start()

        Toast.makeText(context, context.getString(R.string.stored_offline),Toast.LENGTH_SHORT).show()
    }


}