package com.example.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.cities.databinding.FragmentRouletteBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_demo_sheet.*

class RouletteFragment : Fragment() {
    private var _binding: FragmentRouletteBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRouletteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBehavior(view.findViewById(R.id.bottom_sheet_container))
        item_list.initialize(itemAdapter)
        item_list.setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
        itemAdapter.setItems(getLargeListOfItems())
    }

    private fun bottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
    }

    private val itemAdapter by lazy {
        ItemAdapter { position: Int, item: Item ->
            //   Toast.makeText(this@RouletteFragment, "Pos ${position}", Toast.LENGTH_LONG).show()
            country_city.text = item.title
            val data =
                listOf("Москва", "Санкт-Петербург", "Екатеринбург", "Нижний Новгород", "Владимир").toString()
            if (item.title == "Россия") {
                country_city.text = data
            } else {country_city.text = "Список пуст"}
            item_list.smoothScrollToPosition(position)
        }
    }

    private val possibleItems = listOf(
        Item("Украина", R.drawable.ic_ua),
        Item("Латвия", R.drawable.ic_lv),
        Item("Россия", R.drawable.ic_ru),
        Item("Армения", R.drawable.ic_am),
        Item("Грузия", R.drawable.ic_ge),

        )

    private fun getLargeListOfItems(): List<Item> {
        val items = mutableListOf<Item>()
        (0..40).map { items.add(possibleItems.random()) }
        return items
    }
}

data class Item(
    val title: String,
    @DrawableRes val icon: Int
)
