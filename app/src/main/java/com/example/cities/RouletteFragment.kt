package com.example.cities

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cities.Bottom.BottomSheetFragment
import com.example.cities.Bottom.SuperBottomSheetFragment
import kotlinx.android.synthetic.main.activity_demo.*

class RouletteFragment : Fragment(){
    // inflate the layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_table, container, false)
    }
}