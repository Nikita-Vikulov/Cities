package com.example.cities.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cities.R
import com.example.cities.databinding.CardViewDesignBinding


class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {


    inner class CustomViewHolder(private val itemViewBinding: CardViewDesignBinding) :
        RecyclerView.ViewHolder(
            itemViewBinding.root
        ) {
        val yearCity: TextView = itemView.findViewById(R.id.yearCity)
        val nameCity: TextView = itemView.findViewById(R.id.nameCity)

        fun bindView(movieItem: String) {
            itemViewBinding.apply {
                nameCity.text = movieItem
                yearCity.text = movieItem
            }

            itemViewBinding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(movieItem)

                }
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.contentEquals(newItem)
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.contentEquals(newItem)
        }


    }

    val differ = AsyncListDiffer(this, differCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(

            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.card_view_design, parent, false
            )

        )
    }

    private var onItemClickListener: ((String) -> Unit)? = null
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.yearCity.text = ItemsViewModel.year.toString()
        holder.nameCity.text = ItemsViewModel.name
        val movieItem = differ.currentList[position]
        holder.bindView(movieItem)
    }


    fun moveItem(from: Int, to: Int) {

        val list = differ.currentList.toMutableList()
        val fromLocation = list[from]
        list.removeAt(from)
        if (to < from) {
            list.add(to + 1, fromLocation)
        } else {
            list.add(to - 1, fromLocation)
        }
        differ.submitList(list)


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener

    }
}

/*
class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.yearCity.text = ItemsViewModel.year.toString()
        holder.nameCity.text = ItemsViewModel.name

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val yearCity: TextView = itemView.findViewById(R.id.yearCity)
        val nameCity: TextView = itemView.findViewById(R.id.nameCity)
    }
}*/
