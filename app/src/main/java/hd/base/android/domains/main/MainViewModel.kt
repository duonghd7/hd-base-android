package hd.base.android.domains.main

import android.util.Log
import hd.base.android.base.BaseViewModel

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class MainViewModel : BaseViewModel() {
    companion object {
        private val TAG = MainViewModel::class.simpleName ?: ""
    }

    init {
        Log.e(TAG, "init")
    }
}