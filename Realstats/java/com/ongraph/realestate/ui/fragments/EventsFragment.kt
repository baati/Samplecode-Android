package com.ongraph.realestate.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.ongraph.realestate.R
import com.ongraph.realestate.ui.adapter.EventViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_event.view.*
import kotlinx.android.synthetic.main.tab_layout.view.*

class EventsFragment : Fragment() {

    lateinit var convertView:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        convertView=inflater.inflate(R.layout.fragment_event, container, false)
        setupViewPager()
        return convertView
    }

    private fun setupViewPager() {
        val headerArrayList =
            ArrayList<String>()
        headerArrayList.add(resources.getString(R.string.past))
        headerArrayList.add(resources.getString(R.string.upcomming))

        val fragmentArrayList =
            ArrayList<Fragment>()
        val fragment1 = SubEventFragment()
        val args = Bundle()
        args.putBoolean("index", true)
        fragment1.setArguments(args)

        val fragment2 = SubEventFragment()
        val args2 = Bundle()
        args2.putBoolean("index", false)
        fragment2.setArguments(args2)

        fragmentArrayList.add(fragment1)
        fragmentArrayList.add(fragment2)


        convertView.viewPager.setAdapter(
            EventViewPagerAdapter(
                activity,
                childFragmentManager,
                fragmentArrayList,
                headerArrayList
            )
        )

        convertView.tabLayout.setupWithViewPager(convertView.viewPager)
        convertView.viewPager.offscreenPageLimit=1

     /*   convertView.tabLayout.getTabAt(1)!!.setCustomView(R.layout.tab_layout) ;

        convertView.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { //do stuff here
                convertView.viewPager.currentItem = tab.position;
                var view = convertView.tabLayout!!.getTabAt(1)!!.customView!!
                if (tab.position == 1){
                    view.tab1.setTextColor(resources.getColor(R.color.colorAccent))
                }else{
                    view.tab1.setTextColor(resources.getColor(R.color.white))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })*/
    }
}
