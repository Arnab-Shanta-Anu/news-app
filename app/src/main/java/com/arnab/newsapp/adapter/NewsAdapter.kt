package com.arnab.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arnab.newsapp.R
import com.arnab.newsapp.viewmodel.NewsViewModel
import com.bumptech.glide.Glide

class NewsAdapter(
    private val context: Context,
    private val viewModel: NewsViewModel
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val dataSet = viewModel.status

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImage: ImageView = itemView.findViewById(R.id.news_img)
        val newsTitle: TextView = itemView.findViewById(R.id.news_title)
        val newsShortDesc: TextView = itemView.findViewById(R.id.news_short_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet.value?.get(position)

        Glide.with(context).load(item!!.urlToImage).into(holder.newsImage)
        holder.newsTitle.text = item!!.title
        holder.newsShortDesc.text = item!!.content

    }

    override fun getItemCount(): Int {
        return dataSet.value?.size ?: 0
    }
}