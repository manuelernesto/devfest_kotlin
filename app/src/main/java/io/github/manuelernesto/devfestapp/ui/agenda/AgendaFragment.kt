package io.github.manuelernesto.devfestapp.ui.agenda

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import io.github.manuelernesto.devfestapp.R
import io.github.manuelernesto.devfestapp.ui.agenda.cloud.CloudFragment
import io.github.manuelernesto.devfestapp.ui.agenda.mobile.MobileFragment
import io.github.manuelernesto.devfestapp.ui.agenda.web.WebFragment

class AgendaFragment : Fragment() {

    companion object {
        fun newInstance() = AgendaFragment()
    }

    private lateinit var viewModel: AgendaViewModel
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.agenda_fragment, container, false).apply {
            mTabLayout = findViewById(R.id.tabs_agenda)
            mViewPager = findViewById(R.id.viewpager)

            setupViewPager(mViewPager)
            mTabLayout.setupWithViewPager(mViewPager)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mTabLayout.getTabAt(0)?.icon =
                    resources.getDrawable(R.drawable.ic_cloud, null)
                mTabLayout.getTabAt(1)?.icon =
                    resources.getDrawable(R.drawable.ic_phone, null)
                mTabLayout.getTabAt(2)?.icon =
                    resources.getDrawable(R.drawable.ic_web, null)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgendaViewModel::class.java)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(activity!!.supportFragmentManager)
        adapter.addFragment(CloudFragment(), "Cloud")
        adapter.addFragment(MobileFragment(), "Mobile")
        adapter.addFragment(WebFragment(), "Web and More")
        viewPager.adapter = adapter
    }

    class ViewPagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {

        private val mFragmentList: ArrayList<Fragment> = ArrayList()
        private val mFragmentTitle: ArrayList<String> = ArrayList()

        override fun getItem(position: Int) = mFragmentList[position]

        override fun getCount() = mFragmentList.size

        override fun getPageTitle(position: Int) = mFragmentTitle[position]


        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitle.add(title)
        }

    }
}
