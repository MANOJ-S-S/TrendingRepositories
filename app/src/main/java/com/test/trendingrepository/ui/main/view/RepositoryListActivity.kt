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
import com.test.trendingrepository.R
import com.test.trendingrepository.data.model.RepositoryDataItem
import com.test.trendingrepository.ui.main.adapter.RepositoryAdapter
import com.test.trendingrepository.ui.main.viewmodel.RepositoryListViewModel
import kotlinx.android.synthetic.main.activity_repository_list.*

class RepositoryListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var allRepositoryList: List<RepositoryDataItem>
    private lateinit var searchedRepositoryList: List<RepositoryDataItem>
    private lateinit var adapter: RepositoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)

        val viewModel = ViewModelProviders.of(this@RepositoryListActivity).get(RepositoryListViewModel::class.java)
        setupUI()


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


    private fun setupUI() {

        back_button.setOnClickListener(this)


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

    private fun showAllRepositories(repositories: List<RepositoryDataItem>) {

        allRepositoryList = repositories
        adapter.addData(allRepositoryList)
        adapter.notifyDataSetChanged()

    }


    private fun showErrorMessage(error: String) {

        Toast.makeText(baseContext, error, Toast.LENGTH_SHORT).show()

    }

    override fun onClick(view: View?) {

        when(view!!.id){

             R.id.back_button -> {
                 search_view.onActionViewCollapsed()
                 trending_title.visibility = View.VISIBLE
                 back_button.visibility = View.GONE
             }



            else -> {}
        }


    }

}