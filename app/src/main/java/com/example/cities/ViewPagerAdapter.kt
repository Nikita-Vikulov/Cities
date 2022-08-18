package com.example.cities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TableFragment()
            }
            else -> {
                return RouletteFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
  /* override fun onBindViewHolder(){

   }*/
    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            else -> {
                return "Second Tab"
            }
        }
    }
}