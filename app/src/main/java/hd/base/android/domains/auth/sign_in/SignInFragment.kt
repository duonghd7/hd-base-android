package hd.base.android.domains.auth.sign_in

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import hd.base.android.R
import hd.base.android.base.BaseFragment
import hd.base.android.databinding.FragmentSignInBinding
import hd.base.android.domains.auth.AuthViewModel

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class SignInFragment : BaseFragment<FragmentSignInBinding>(R.layout.fragment_sign_in) {

    companion object {
        private val TAG = SignInFragment::class.simpleName ?: ""
    }

    private val viewModel: AuthViewModel by activityViewModels()

    override fun setBinVariable(binding: FragmentSignInBinding) {
        binding.viewModel = viewModel
    }

    override fun initViews(view: View) {
        Log.e(TAG, "initViews")

        binding.apply {
            tvBack.setOnClickListener {
                activity?.onBackPressed()
            }

            tvLogin.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(context, "Invalid username or password!", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel?.signIn(username, password)
                }
            }

            tvSignUp.setOnClickListener {
                viewModel?.toSignUp?.postValue(true)
            }
        }
    }

    override fun initData() {
        Log.e(TAG, "initData")
    }
}