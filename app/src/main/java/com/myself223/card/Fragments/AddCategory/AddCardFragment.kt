
package com.myself223.card.Fragments.AddCategory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.myself223.card.App
import com.myself223.card.R
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.FragmentAddCardBinding


class AddCardFragment : Fragment() {
    private val binding: FragmentAddCardBinding by lazy {
        FragmentAddCardBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root

    }
}/*

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val text = arguments?.getString("key").toString()
            if (text == "element") {
                val pos = arguments?.getInt("position")!!
                val list = arguments?.getSerializable("list") as List<CategoryModel>

                binding.btnSave.setOnClickListener {
                    val name = binding.edNameCategory.text.toString()
                    val models = ArrayList<CategoryModel>()
                    models.add(CategoryModel(name = name, image = ""))

                    App.database.getDao().updateCard(
                        CardModel(
                        list[pos].id,
                        list[pos].name, models)
                    )
                    findNavController().navigateUp()
                }
            } else {
                binding.btnSave.setOnClickListener {
                    val name = binding.edNameCategory.text.toString()
                    val list = ArrayList<CategoryModel>()

                    App.database.getDao().insertCard(
                        CardModel(name = name, list = list)
                    )
                    findNavController().navigateUp()
                }
            }
        }
    }


}*/
