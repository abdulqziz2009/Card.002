package com.myself223.card.Fragments.AddCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myself223.card.App
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.FragmentAddCategoryBinding


class AddCategoryFragment : BottomSheetDialogFragment() {

    private val binding: FragmentAddCategoryBinding by lazy {
        FragmentAddCategoryBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val text = arguments?.getString("key").toString()
            if (text == "element") {
                val pos = arguments?.getInt("position")!!
                val list = arguments?.getSerializable("list") as List<CardModel>

                binding.btnSave.setOnClickListener {
                    val name = binding.edNameCategory.text.toString()
                    val models = ArrayList<CategoryModel>()
                    models.addAll(list[pos].list)
                    models.add(CategoryModel(name = name, image = ""))

                    App.database.getDao().updateCard(CardModel(
                        list[pos].id,
                        list[pos].name, models))
                    findNavController().navigateUp()
                }
            } else {
                binding.btnSave.setOnClickListener {
                    val name = binding.edNameCategory.text.toString()
                    val list = ArrayList<CategoryModel>()

                    App.database.getDao().insertCard(
                        CardModel(name = name, list = list))
                    findNavController().navigateUp()
                }
            }
        }
    }
}