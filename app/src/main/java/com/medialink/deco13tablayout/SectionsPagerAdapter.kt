package com.medialink.deco13tablayout

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.medialink.deco13tablayout.ui.main.PlaceholderFragment
import com.medialink.deco13tablayout.ui.profile.ProfileFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLE = intArrayOf(R.string.tab_text_1, R.string.tab_text_2,
        R.string.tab_text_3)

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = PlaceholderFragment.newInstance(position+1)
            1 -> fragment = ProfileFragment()
            2 -> fragment = PlaceholderFragment.newInstance(position+1)
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLE[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return TAB_TITLE.size
    }
}