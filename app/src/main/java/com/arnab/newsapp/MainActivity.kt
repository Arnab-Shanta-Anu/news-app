package com.arnab.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.arnab.newsapp.adapter.ViewPagerAdapter
import com.arnab.newsapp.ui.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

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