package com.myself223.card.Fragments.Category

import CategoryAdapter
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.myself223.card.R
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(), CategoryAdapter.Result {


    private val binding: FragmentCategoryBinding by lazy {
        FragmentCategoryBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: CategoryAdapter
    private var pos = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addCategoryFragment)
        }


        initAdapter()
        if (arguments != null) {
            val list = arguments?.getSerializable("list") as List<CardModel>
            pos = arguments?.getInt("pos")!!
            adapter.setList(list[pos].list)


            binding.btnAdd.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("key", "element")
                val model = ArrayList(list)
                bundle.putSerializable("list", model)
                bundle.putInt("position", pos)
                findNavController().navigate(R.id.addCategoryFragment, bundle)
            }

        }


    }

    private fun initAdapter() {
        adapter = CategoryAdapter(this)
        binding.rvMain.adapter = adapter
    }


    override fun OnClick2(list: List<CategoryModel>, pos: Int) {
        val bundle = Bundle()
        val cat = ArrayList(list)
        bundle.putSerializable("daun", cat)
        bundle.putInt("position", pos)
        findNavController().navigate(R.id.openedCategory, bundle)
    }
}




