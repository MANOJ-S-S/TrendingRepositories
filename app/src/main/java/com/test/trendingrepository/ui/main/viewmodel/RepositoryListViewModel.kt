package com.test.trendingrepository.ui.main.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.trendingrepository.data.model.OfflineRepositoryDataItem
import com.test.trendingrepository.data.model.RepositoryDataItem
import com.test.trendingrepository.data.repository.MainRepository
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList


class RepositoryListViewModel  : ViewModel() {


    var mainRepository = MainRepository.instance()

    //lazy initialization
    val repositoryList : MutableLiveData<List<RepositoryDataItem>> by lazy {
        MutableLiveData<List<RepositoryDataItem>>()
    }
    val errorResponse :  MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val progressValue :  MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private var compositeDisposable = CompositeDisposable()

    //This method returns the data as LiveData because the data from api should  be observed alone and  should not be edited
    fun getRepositories(context: Context) : LiveData<List<RepositoryDataItem>> {
        compositeDisposable.add(mainRepository.getAllRepositories(this, context))
        return  repositoryList
    }


    fun getProgressValue () : LiveData<Boolean>{
        return progressValue
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


    fun searchRepository(newText: String?, repositoryDataItem: List<RepositoryDataItem> ) : List<RepositoryDataItem> {

        // creating a new array list to filter our data.
        val filteredList: ArrayList<RepositoryDataItem> = ArrayList()

        for (item in repositoryDataItem) {
            // checking if the entered string matched with any repository name in our recycler view.
            if (item.name.trim().toLowerCase(Locale.getDefault()).contains(newText!!.trim().toLowerCase(Locale.getDefault()))) {
                // if the item is matched we add it to our filtered list.
                filteredList.add(item)
            }
        }
        return filteredList
    }


}