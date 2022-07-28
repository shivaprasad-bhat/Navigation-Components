package me.svbneelmane.navigation_components

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private fun doSignIn(view: View) {
        val result =
            loginBinding.username.text.toString() == "admin" && loginBinding.password.text.toString() == "admin"
        if (result) {
            Navigation.findNavController(view).navigate(R.id.navigateToWelcome)
        } else {
            AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setMessage("Invalid User Name or Password")
                .setTitle("Failed to Login")
                .show()
        }
    }

}