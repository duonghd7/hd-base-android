package hd.base.android.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Create on 22/01/2022
 * @author duonghd
 */

abstract class BaseActivity<B : ViewDataBinding>(@LayoutRes private val layoutId: Int) : AppCompatActivity() {
    private val job = Job()
    val ioScope = CoroutineScope(Dispatchers.IO + job)
    val mainScope = CoroutineScope(Dispatchers.Main + job)

    lateinit var binding: B

    protected abstract fun setBinVariable(binding: B)
    protected abstract fun initViews()
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this@BaseActivity
        binding.executePendingBindings()

        setBinVariable(binding = binding)
        initViews()
        initData()
    }

    fun <T> LiveData<T>.observe(listener: (T) -> (Unit)) {
        observe(this@BaseActivity, {
            listener.invoke(it)
        })
    }
}