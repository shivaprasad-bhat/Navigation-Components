package me.svbneelmane.navigation_components

/**
 * Fragment to hold the Welcome screen UI
 * @author shivaprasad-bhat
 * @date-created 27-Jul-22
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import me.svbneelmane.navigation_components.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var welcomeBinding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        welcomeBinding = FragmentWelcomeBinding.inflate(inflater)
        welcomeBinding.buttonGoBack.setOnClickListener {
            doGoBack(it)
        }
        return welcomeBinding.root
    }

    /**
     * function to do a back navigation
     */
    private fun doGoBack(view: View) {
        Navigation.findNavController(view).navigate(R.id.navigateToLogin)
    }
}