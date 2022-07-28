package me.svbneelmane.navigation_components

/**
 * Fragment to hold the Login UI
 * @author shivaprasad-bhat
 * @date-created 27-Jul-22
 */
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import me.svbneelmane.navigation_components.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = FragmentLoginBinding.inflate(layoutInflater)
        loginBinding.login.setOnClickListener {
            doSignIn(it)
        }
        return loginBinding.root
    }

    /**
     * Validate the static user name password with user entered values
     * show alert if wrong
     * do a navigation if correct values are entered
     */
    private fun doSignIn(view: View) {
        val action =
            LoginFragmentDirections.navigateToWelcome(loginBinding.username.text.toString())
        val result =
            loginBinding.username.text.toString() == "admin" && loginBinding.password.text.toString() == "admin"
        if (result) {
            Navigation.findNavController(view).navigate(action)
        } else {
            AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setMessage("Invalid User Name or Password")
                .setTitle("Failed to Login")
                .show()
        }
    }

}