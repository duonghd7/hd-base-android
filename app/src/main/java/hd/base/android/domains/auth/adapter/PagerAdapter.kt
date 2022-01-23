package hd.base.android.domains.auth.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class PagerAdapter(
    fragmentActivity: FragmentActivity,
    private val fragmentItems: MutableList<Fragment>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return fragmentItems.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentItems[position]
    }
}
