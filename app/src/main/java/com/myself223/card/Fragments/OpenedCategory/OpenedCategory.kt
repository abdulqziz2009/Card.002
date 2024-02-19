package com.example.card.fragments.stadyFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myself223.card.R
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.FragmentOpenedCategoryBinding

class OpenedCategory : BottomSheetDialogFragment() {
    private val binding: FragmentOpenedCategoryBinding by lazy {
        FragmentOpenedCategoryBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
        val pos = arguments?.getInt("position")
        val text = arguments?.getSerializable("daun") as List<CategoryModel>
        binding.nameC.text = text[pos!!].name
    }


}