package com.arnab.newsapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arnab.newsapp.R
import com.arnab.newsapp.model.Article
import com.arnab.newsapp.ui.WebViewFragment
import com.bumptech.glide.Glide

class NewsAdapter(
    private val context: Context,
    private val dataSet: List<Article>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImage: ImageView = itemView.findViewById(R.id.news_img)
        val newsTitle: TextView = itemView.findViewById(R.id.news_title)
        val newsShortDesc: TextView = itemView.findViewById(R.id.news_short_description)
        val continueReading: TextView = itemView.findViewById(R.id.continue_reading)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        Log.d(
            "NewsAdapter",
            "onBindViewHolder: data \n${item.urlToImage}\n${item.title}\n${item.content}"
        )
        Glide.with(context).load(item.urlToImage).into(holder.newsImage)
        holder.newsTitle.text = item.title
        holder.newsShortDesc.text = item.description
        holder.continueReading.setOnClickListener {
            WebViewFragment(item.url!!)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}