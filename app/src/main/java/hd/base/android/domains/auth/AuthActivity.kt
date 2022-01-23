package hd.base.android.domains.auth

import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import hd.base.android.R
import hd.base.android.base.BaseActivity
import hd.base.android.databinding.ActivityAuthBinding
import hd.base.android.domains.auth.adapter.PagerAdapter
import hd.base.android.domains.auth.sign_in.SignInFragment
import hd.base.android.domains.auth.sign_up.SignUpFragment

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class AuthActivity : BaseActivity<ActivityAuthBinding>(R.layout.activity_auth) {

    companion object {
        private val TAG = AuthActivity::class.simpleName ?: ""
    }

    private val viewModel: AuthViewModel by viewModels()

    override fun setBinVariable(binding: ActivityAuthBinding) {
        binding.viewModel = viewModel
    }

    override fun initViews() {
        Log.e(TAG, "initViews")

        val fragmentItems = mutableListOf<Fragment>()
        fragmentItems.add(SignInFragment())
        fragmentItems.add(SignUpFragment())
        binding.viewPager.adapter = PagerAdapter(this, fragmentItems)
    }

    override fun initData() {
        Log.e(TAG, "initData")

        viewModel.apply {
            toSignIn.observe {
                it ?: return@observe
                if (it && binding.viewPager.currentItem != 0) {
                    binding.viewPager.setCurrentItem(0, true)
                }
                toSignIn.postValue(null)
            }

            toSignUp.observe {
                it ?: return@observe
                if (it && binding.viewPager.currentItem != 1) {
                    binding.viewPager.setCurrentItem(1, true)
                }
                toSignUp.postValue(null)
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}