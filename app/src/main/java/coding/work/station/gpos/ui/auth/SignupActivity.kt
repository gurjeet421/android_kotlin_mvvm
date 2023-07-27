package coding.work.station.gpos.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coding.work.station.gpos.R
import coding.work.station.gpos.databinding.ActivitySignupBinding
import coding.work.station.gpos.ui.home.HomeActivity
import coding.work.station.gpos.util.snackbar
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(), KodeinAware {

    // kodein framework used for dependency Injection
    override val kodein by kodein()

    private val factory: AuthViewModelFactory by instance()

    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]


        viewModel.getLoggedInUser().observe(this) { user ->
            if (user != null) {
                // Here
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }

        binding.btnSignUp.setOnClickListener {
            userSignUp()
        }
    }

    private fun userSignUp() {
        val name = binding.editTextName.text.toString().trim()
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()

        //@todo validation user input
        lifecycleScope.launch {
            try {
                val authResponse = viewModel.userSIgnUp(name, email, password)

                if (authResponse.user != null) {
                    viewModel.saveLoggedInUser(authResponse.user)
                } else {
                    binding.rootLayout.snackbar(authResponse.message!!)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}