package hd.base.android.domains.main

import android.content.Intent
import android.util.Log
import hd.base.android.R
import hd.base.android.base.BaseActivity
import hd.base.android.databinding.ActivityMainBinding
import hd.base.android.domains.auth.AuthActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    companion object {
        private val TAG = MainActivity::class.simpleName ?: ""
    }

    private val viewModel: MainViewModel by viewModel()

    override fun setBinVariable(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
    }

    override fun initViews() {
        Log.e(TAG, "initViews")

        binding.tvSignIn.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
        }
    }

    override fun initData() {
        Log.e(TAG, "initData")
    }
}