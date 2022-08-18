package com.example.cities

import android.app.ProgressDialog.show
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.cities.Bottom.SuperBottomSheetFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior

class RouletteFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_table, container, false)
    }

    fun show(){
        val sheet = BottomSheetFragment()
        fragmentManager?.let { sheet.show(it, "DemoBottomSheetFragment") }
    }
}