package hd.base.android.domain.activity

import android.os.Bundle
import hd.base.android.R
import hd.base.android.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}