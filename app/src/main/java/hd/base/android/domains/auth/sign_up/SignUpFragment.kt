package hd.base.android.domains.auth.sign_up

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import hd.base.android.R
import hd.base.android.base.BaseFragment
import hd.base.android.databinding.FragmentSignUpBinding
import hd.base.android.domains.auth.AuthViewModel

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    companion object {
        private val TAG = SignUpFragment::class.simpleName ?: ""
    }

    private val viewModel: AuthViewModel by activityViewModels()

    override fun setBinVariable(binding: FragmentSignUpBinding) {
        binding.viewModel = viewModel
    }

    override fun initViews(view: View) {
        Log.e(TAG, "initViews")

        binding.apply {
            tvBack.setOnClickListener {
                activity?.onBackPressed()
            }

            tvRegister.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context, "Invalid username or password!", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel?.signUp(username, password)
                }
            }

            tvSignIn.setOnClickListener {
                viewModel?.toSignIn?.postValue(true)
            }
        }
    }

    override fun initData() {
        Log.e(TAG, "initData")
    }
}