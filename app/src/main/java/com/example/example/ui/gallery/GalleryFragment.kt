package com.example.example.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.example.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val loginGal = root.findViewById<EditText>(R.id.edt_login_gallery)
        val passGal = root.findViewById<EditText>(R.id.edt_pass_gallery)
        val pass2Gal = root.findViewById<EditText>(R.id.edt_pass_gallery_2)
        val btnGal = root.findViewById<Button>(R.id.btn_signUn)

        btnGal.setOnClickListener {
            if(loginGal.text.isNotEmpty() && passGal.text.isNotEmpty() && pass2Gal.text.isNotEmpty()){
                if (passGal.text.toString().equals(pass2Gal.text.toString())){
                    val Login = loginGal.text.toString()
                    val Pass = passGal.text.toString()
                    val array = arrayOf<String>(Login,Pass)
                    val action = GalleryFragmentDirections.actionNavGalleryToNavHome(array)

                    loginGal.text.clear()
                    passGal.text.clear()
                    pass2Gal.text.clear()


                    Navigation.findNavController(root).navigate(action)

                }else{
                    Toast.makeText(requireContext(), "Parollarda moslik yo'q!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(), "Ma'lumotlat to'liq kiritilmadi!", Toast.LENGTH_SHORT).show()
            }
        }




        return root
    }
}