package com.example.cities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //activity_demo
        val fragmentAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
        viewPager.currentItem = 1
       // show()
        // SuperBottomSheetFragment.callback

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = mutableListOf<ItemsViewModel>()
        data.add(ItemsViewModel("Москва", 1147))
        data.add(ItemsViewModel("Санкт-Петербург", 1703))
        data.add(ItemsViewModel("Екатеринбург", 1723))
        data.add(ItemsViewModel("Нижний Новгород", 1221))
        data.add(ItemsViewModel("Владимир", 990))
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

    }


    private fun show() {
        val sheet = BottomSheetFragment()
        sheet.show(supportFragmentManager, "DemoBottomSheetFragment")
    }

}