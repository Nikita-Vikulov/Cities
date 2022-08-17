package com.example.cities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cities.Bottom.BottomSheetFragment
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //activity_demo

        val fragmentAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

        tabs.setOnClickListener {
            val sheet = BottomSheetFragment()
            sheet.show(supportFragmentManager, "DemoBottomSheetFragment")
        }
    }

   /* private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: Toolbar    // creating object of ToolBar

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    var listOfCities: ArrayList<Model> = ArrayList()

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..4) {
            val city = Model()
            city.name = "Москва $i"
            city.year = i
            listOfCities.add(city)
        }
        mRecyclerView = findViewById(R.id.recyclerView)
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView?.layoutManager = mLayoutManager
        mAdapter = MyAdapter(listOfCities)
        mRecyclerView?.adapter = mAdapter

        // set the references of the declared objects above
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)
        setSupportActionBar(bar)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TableFragment(), "Table fragment")
        adapter.addFragment(RouletteFragment(), "Roulette fragment")
        pager.adapter = adapter
        tab.setupWithViewPager(pager)

       *//* pager.setOnClickListener {
            CustomBottomSheetDialogFragment().apply {
                show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG)
            }
        }*//*

        pager.setOnClickListener {

            val dialog = BottomSheetDialog(this)

            dialog.setContentView(R.layout.fragment_roulette)

            val RLEdit = dialog.findViewById<RelativeLayout>(R.id.rl_edit)
            val RLDelete = dialog.findViewById<RelativeLayout>(R.id.rl_delete)
            val RLAdd = dialog.findViewById<RelativeLayout>(R.id.rl_add)

            RLEdit?.setOnClickListener {  //handle click event
                Toast.makeText(this, "Perform edit operation", Toast.LENGTH_SHORT).show()
            }
            RLDelete?.setOnClickListener {  //handle click event
                Toast.makeText(this, "Perform delete operation", Toast.LENGTH_SHORT).show()
            }
            RLAdd?.setOnClickListener {  //handle click event
                Toast.makeText(this, "Perform add operation", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }
    }*/

}