package com.test.trendingrepository.data.repository

import android.content.Context
import com.test.trendingrepository.data.api.RetrofitBuilder
import com.test.trendingrepository.ui.main.viewmodel.RepositoryListViewModel
import com.test.trendingrepository.utils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainRepository {


    companion object {

        private var mainRepository: MainRepository? = null

        fun instance(): MainRepository {
            if (mainRepository == null) synchronized(MainRepository) {
                mainRepository = MainRepository()
            }
            return mainRepository!!
        }

    }

    /* Returns the disposable from rx java */

   fun getAllRepositories(viewModel: RepositoryListViewModel, context: Context) : Disposable {

       return RetrofitBuilder.getInstance(context, Utils.BASE_URL)
           .getRepositories()
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())
           .subscribe({
               viewModel.repositoryList.value = it
           }, {
               viewModel.errorResponse.value = it.message
           })

   }


}