package com.test.trendingrepository.ui.main.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.trendingrepository.R
import com.test.trendingrepository.data.model.RepositoryDataItem
import kotlinx.android.synthetic.main.repository_listitem_layout.view.*


class RepositoryAdapter(
    private var repositories: ArrayList<RepositoryDataItem>, private val context: Context
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.repository_listitem_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = repositories.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
        holder.bind(repositories[position], context)
    

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repository: RepositoryDataItem, context: Context) {
            itemView.author_name.text = repository.author
            itemView.repo_name.text = repository.name
            itemView.repo_description.text = repository.description
            // to parse the colour into bitmap and set it to image source
            val colors = intArrayOf(Color.parseColor(repository.languageColor))
            val bitmap: Bitmap = Bitmap.createBitmap(colors, 1, 1, Bitmap.Config.RGB_565)
                 Glide.with(context)
           .load(bitmap)
           .into(itemView.language_colour)
            itemView.language.text = repository.language
            itemView.stars_tv.text = repository.stars.toString()
        }
    }

    fun addData(list: List<RepositoryDataItem>) {
        repositories.clear()
        repositories.addAll(list)
    }

    // method for filtering our recyclerview items.

    fun filterList(filterList: ArrayList<RepositoryDataItem>) {
        repositories = filterList
        notifyDataSetChanged()
    }

}
