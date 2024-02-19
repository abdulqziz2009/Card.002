package com.myself223.card.Fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.myself223.card.App
import com.myself223.card.R
import com.myself223.card.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var navController: NavController? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.btnSignUp.setOnClickListener{
            findNavController().navigateUp()
            findNavController().navigate(R.id.registerFragment)
        }     /*   val bundle = Bundle()
         if (arguments!= null){
             binding.etNameLoshpeca.setText(requireArguments().getString("changeName"))
             binding.etFmChecely.setText(requireArguments().getString("changeFamili"))
             binding.etEmail.setText(requireArguments().getString("changeEmail"))
         binding.btnSave.setOnClickListener {
             val changeName = binding.etNameLoshpeca.text.toString()
             val changeSureName = binding.etFmChecely.text.toString()
             val changeEmail = binding.etEmail.text.toString()
             val position = requireArguments().getInt("position")
             val profile = ProfileModels(null,changeName,changeSureName,changeEmail)
             bundle.putSerializable("edit_Profile",profile)
             bundle.putInt("position", position)
             requireActivity().supportFragmentManager.setFragmentResult("change_Profile", bundle)
             requireActivity().supportFragmentManager.popBackStack()

         }
     } else {
         binding.addImg.setOnClickListener{
             val name = binding.etNameLoshpeca.text.toString()
             val sName = binding.etFmChecely.text.toString()
             val email = binding.etEmail.text.toString()


             val profileModels = ProfileModels(name = name, Famile = sName, email = email)
             App.MainDb.getDao().insertNotes(notes)
             navController?.navigateUp()
         }
     }*/
        val txtName = App.prefs.showName()
        val email = App.prefs.showEmail()
        binding.name.text = txtName
        binding.email.text = email
        binding.btnSave.setOnClickListener{
            val name = binding.etNameLoshpeca.text.toString()
            App.prefs.saveName(name)
            val  saveName = App.prefs.showName()
            binding.name.text = saveName

            val email = binding.etEmail.text.toString()
            App.prefs.saveEmail(email)
            val saveEmail = App.prefs.showEmail()
            binding.email.text = saveEmail


        }

    binding.addImg.setOnClickListener {
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, 1)
    }
}

    }



