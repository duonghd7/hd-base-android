package hd.base.android.domains.main

import android.util.Log
import androidx.activity.viewModels
import hd.base.android.R
import hd.base.android.base.BaseActivity
import hd.base.android.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    companion object {
        private val TAG = MainActivity::class.simpleName ?: ""
    }

    private val viewModel: MainViewModel by viewModels()

    override fun setBinVariable(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
    }

    override fun initViews() {
        Log.e(TAG, "initViews")
    }

    override fun initData() {
        Log.e(TAG, "initData")
    }
}