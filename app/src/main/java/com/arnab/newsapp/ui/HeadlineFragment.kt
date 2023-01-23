package com.arnab.newsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arnab.newsapp.R
import com.arnab.newsapp.adapter.NewsAdapter
import com.arnab.newsapp.viewmodel.NewsViewModel

class HeadlineFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        /*newsViewModel.newsData.observe(viewLifecycleOwner){
            recyclerView.adapter = NewsAdapter(requireContext(),it.articles)
        }*/
        newsViewModel.allNews.observe(viewLifecycleOwner){
            recyclerView.adapter = NewsAdapter(requireContext(), it)
        }
    }
}