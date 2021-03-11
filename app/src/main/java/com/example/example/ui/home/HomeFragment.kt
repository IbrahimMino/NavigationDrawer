package com.example.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.example.R

class HomeFragment : Fragment() {

    val args:HomeFragmentArgs by navArgs()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        val login = root.findViewById<EditText>(R.id.edt_login)
        val pass = root.findViewById<EditText>(R.id.edt_pass)
        val btnSigIn = root.findViewById<Button>(R.id.btn_signIn)
        //Royxatdan otish oynasiga otish
        val sign = root.findViewById<TextView>(R.id.tv_signUp)

            val loginMain = args.array?.get(0)
            val passwordMain = args.array?.get(1)

        btnSigIn.setOnClickListener {
            if (loginMain.equals(login.text.toString()) && passwordMain.equals(pass.text.toString())){
                login.text.clear()
                pass.text.clear()
                Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_slideshow)
            }
        }

        sign.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_gallery)
        }

        return root
    }
}