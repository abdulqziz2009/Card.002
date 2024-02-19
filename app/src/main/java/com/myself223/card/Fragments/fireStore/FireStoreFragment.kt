package com.myself223.card.Fragments.fireStore

import FireStoreModel
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.myself223.card.databinding.FragmentFireStoreBinding


class FireStoreFragment : Fragment() {



    private val binding: FragmentFireStoreBinding by lazy {
        FragmentFireStoreBinding.inflate(layoutInflater)
    }
    private val db  = FirebaseFirestore.getInstance()
    private val list2: MutableMap<String,Any> = HashMap()
    private lateinit var adapter: FireStoreAdapter
    private var imageUri:Uri? = null
    private lateinit var storage  : StorageReference
    private var img = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        storage  = FirebaseStorage.getInstance().reference.child("image")
        db.collection("popuski").get().addOnSuccessListener {
            val list:MutableList<FireStoreModel> = ArrayList()
            for (d in it.documents){
                val model = d.toObject(FireStoreModel::class.java)?:FireStoreModel()
                model.id =d.id
                list.add(model!!)

            }
          // adapter.stList(list)
            Glide.with(requireActivity()).load(list[0].image).into(binding.imgUser)
        }
        initImage()
        initUpdate()

    }
    private val resultLauncher  = registerForActivityResult(
        ActivityResultContracts.GetContent()){
        imageUri = it
        binding.imgUser.setImageURI(it)
    }
    private fun initImage(){
        binding.imgUser.setOnClickListener {
            resultLauncher.launch("image/*")
        }
    }
    private fun initUpdate(){
        binding.btnChange.setOnClickListener{

            storage = storage.child(System.currentTimeMillis().toString())
            imageUri?.let {

                storage.putFile(it).addOnCompleteListener {
                    if (it.isSuccessful) {
                        storage.downloadUrl.addOnSuccessListener {
                            list2["image"] = it
                            db.collection("popuski").add(list2)

                            makeText(requireActivity(), "Success insert", Toast.LENGTH_SHORT).show()
                        }
                    }

                }.addOnFailureListener {
                    it.localizedMessage.let {it-> Log.e("Ololo",it)

                        makeText (requireActivity(), "Fail insert", Toast.LENGTH_SHORT).show()
                    }
                }

            }
            //insertImage()

        //list2["name"] = "Urmat Lapshok"

      /*  db.collection("pisunchik").document("lapash").set(list2).addOnSuccessListener {
            makeText(requireActivity(),"Success update",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            makeText(requireActivity(),"SomeOneFailur",Toast.LENGTH_SHORT).show()
            }*/
        }
}

    private fun insertImage(){
        storage = storage.child(System.currentTimeMillis().toString())
        imageUri?.let {
            storage.putFile(it).addOnSuccessListener {
                storage.downloadUrl.addOnSuccessListener {
                makeText(requireActivity(), "Success insert", Toast.LENGTH_SHORT).show()
            }
            }.addOnFailureListener {
                it.localizedMessage.let {it-> Log.e("Ololo",it)

                makeText (requireActivity(), "Fail insert", Toast.LENGTH_SHORT).show()
            }
            }

        }

    }
    private fun initAdapter(){
        /*adapter = FireStoreAdapter()
        binding.rvFirestore.adapter = adapter*/

    }
}
