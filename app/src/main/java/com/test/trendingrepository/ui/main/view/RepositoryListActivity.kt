package com.test.trendingrepository.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.R.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.test.trendingrepository.R
import com.test.trendingrepository.data.model.RepositoryDataItem
import com.test.trendingrepository.ui.main.adapter.RepositoryAdapter
import com.test.trendingrepository.ui.main.viewmodel.RepositoryListViewModel
import com.test.trendingrepository.utils.Utils
import kotlinx.android.synthetic.main.activity_repository_list.*

class RepositoryListActivity : AppCompatActivity(), View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var allRepositoryList: List<RepositoryDataItem>
    private lateinit var searchedRepositoryList: List<RepositoryDataItem>
    private lateinit var adapter: RepositoryAdapter
    private lateinit var viewModel: RepositoryListViewModel
    private var isNetworkAvailable : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)
        setupUI()
         viewModel = ViewModelProviders.of(this@RepositoryListActivity).get(RepositoryListViewModel::class.java)


        isNetworkAvailable = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
                             Utils.isNetworkAvailable(context = this)
                             else false


        if(isNetworkAvailable){
            viewModel.getProgressValue().observe(this,
                    {
                        it?.let { response -> handleLoadingBar(response) }
                    }
            )

            viewModel.getRepositories(context = this@RepositoryListActivity).observe(this,
                    Observer {
                        it?.let { response -> showAllRepositories(response) }
                    }
            )

            viewModel.errorResponse.observe(this,
                    Observer {
                        it?.let { errorMsg -> showErrorMessage(errorMsg) }
                    }
            )

            search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    // inside on query text change method we are
                    // calling a method to filter our recycler view.
                    searchedRepositoryList =  viewModel.searchRepository(newText, allRepositoryList )

                    if (searchedRepositoryList.isNotEmpty()){
                        adapter.filterList(searchedRepositoryList as ArrayList<RepositoryDataItem>)
                    }
                    return false
                }
            })
        }

        else {
            showRetryLayout()
        }
    }




    private fun setupUI() {

        back_button.setOnClickListener(this)
        try_again_button.setOnClickListener(this)
        swr_refresh.setOnRefreshListener(this)


        recycle.layoutManager = LinearLayoutManager(this)
            adapter =
                RepositoryAdapter(
                        arrayListOf(), this@RepositoryListActivity)
        recycle.addItemDecoration(
                DividerItemDecoration(
                        recycle.context,
                        (recycle.layoutManager as LinearLayoutManager).orientation
                )
        )
        recycle.adapter = adapter

        search_view.setOnSearchClickListener{
            trending_title.visibility = View.GONE
            back_button.visibility = View.VISIBLE
        }

        search_view.setOnCloseListener {
            trending_title.visibility = View.VISIBLE
            back_button.visibility = View.GONE
            false
        }
    }


    private fun handleLoadingBar( isLoading: Boolean){

      if(isLoading) {
          progress_circle.visibility = View.VISIBLE
          swr_refresh.visibility = View.INVISIBLE
          search_view.visibility = View.INVISIBLE
      }

        else {
          progress_circle.visibility = View.GONE
          retry_layout.visibility = View.GONE
          swr_refresh.visibility = View.VISIBLE
          search_view.visibility = View.VISIBLE
      }

    }


    private fun showAllRepositories(repositories: List<RepositoryDataItem>) {


        allRepositoryList = repositories
        adapter.addData(allRepositoryList)
        adapter.notifyDataSetChanged()

    }

    private fun showErrorMessage(error: String) {
        Toast.makeText(baseContext, error, Toast.LENGTH_SHORT).show()
    }


    private fun showRetryLayout() {
        progress_circle.visibility = View.GONE
        retry_layout.visibility = View.VISIBLE
    }

    override fun onClick(view: View?) {

        when(view!!.id){

             R.id.back_button -> {
                 search_view.onActionViewCollapsed()
                 trending_title.visibility = View.VISIBLE
                 back_button.visibility = View.GONE
             }

            R.id.try_again_button -> {
                    doNetworkCall()
            }

            else -> {}
        }

    }

    private fun doNetworkCall() {
        swr_refresh.isRefreshing = false
        progress_circle.visibility = View.VISIBLE
        isNetworkAvailable = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
            Utils.isNetworkAvailable(context = this)
        else false
        if(isNetworkAvailable){

            viewModel.getProgressValue().observe(this,
                    {
                        it?.let { response -> handleLoadingBar(response) }
                    }
            )
            viewModel.getRepositories(context = this@RepositoryListActivity).observe(this,
                    Observer {
                        showAllRepositories(it)
                    }
            )
            viewModel.errorResponse.observe(this,
                    Observer {
                        it?.let { errorMsg -> showErrorMessage(errorMsg) }
                    }
            )
        }
        else if(!isNetworkAvailable) Snackbar.make(try_again_button, "Please check your internet connection", Snackbar.LENGTH_LONG).show();
    }

    override fun onRefresh() {
       doNetworkCall()
    }

}