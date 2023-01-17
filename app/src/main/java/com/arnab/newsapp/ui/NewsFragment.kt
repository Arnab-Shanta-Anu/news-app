package com.arnab.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.arnab.newsapp.R
import com.arnab.newsapp.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NewsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)

        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout,viewPager){tab,position->
            when(position){
                0 -> tab.text = "Hot Headline"
                1 -> tab.text = "Business"
                2 -> tab.text = "Entertainment"
                3 -> tab.text = "General"
                4 -> tab.text = "Health"
                5 -> tab.text = "Science"
                6 -> tab.text = "Sports"
                7 -> tab.text = "Technology"
            }
        }.attach()
    }
}