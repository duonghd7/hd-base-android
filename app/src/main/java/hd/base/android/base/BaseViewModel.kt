package hd.base.android.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Create on 22/01/2022
 * @author duonghd
 */

abstract class BaseViewModel : ViewModel() {
    private val job = Job()
    val ioScope = CoroutineScope(Dispatchers.IO + job)
    val mainScope = CoroutineScope(Dispatchers.Main + job)
}