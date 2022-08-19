package com.example.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cities.RecyclerView.CustomAdapter
import com.example.cities.RecyclerView.ItemsViewModel
import com.example.cities.databinding.FragmentTableBinding

class TableFragment : Fragment() {

    private var _binding: FragmentTableBinding? = null
    private val binding get() = _binding!!

    private val data = mutableListOf<ItemsViewModel>()
    private lateinit var adapter: CustomAdapter

    private val itemTouchHelper by lazy {
        val simpleItemTouchCallback =
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END,
                0
            ) {

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    //getting the adapter
                    val adapter = recyclerView.adapter as CustomAdapter
                    //the position from where item has been moved
                    val from = viewHolder.adapterPosition
                    //the position where the item is moved
                    val to = target.adapterPosition
                    //telling the adapter to move the item
                    adapter.moveItem(from, to)
                    adapter.notifyItemMoved(from, to)

                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                }

                override fun onSelectedChanged(
                    viewHolder: RecyclerView.ViewHolder?,
                    actionState: Int
                ) {
                    super.onSelectedChanged(viewHolder, actionState)

                    if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                        viewHolder?.itemView?.alpha = 0.5f
                    }
                }

                override fun clearView(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ) {
                    super.clearView(recyclerView, viewHolder)

                    viewHolder.itemView.alpha = 1.0f
                }
            }

        ItemTouchHelper(simpleItemTouchCallback)
    }

  /*  override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTableBinding.inflate(layoutInflater, container, false)
        return binding.root
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //      val recyclerview = binding.recyclerview
        //      recyclerview.adapter = adapter

        data.add(ItemsViewModel("Москва", 1147))
        data.add(ItemsViewModel("Санкт-Петербург", 1703))
        data.add(ItemsViewModel("Екатеринбург", 1723))
        data.add(ItemsViewModel("Нижний Новгород", 1221))
        data.add(ItemsViewModel("Владимир", 990))


        itemTouchHelper.attachToRecyclerView(binding.recyclerview)
        adapter = CustomAdapter()
        adapter.differ.submitList(data)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter
        /*val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter*/
    }


    companion object {
        fun newInstance() = TableFragment()
    }
}
