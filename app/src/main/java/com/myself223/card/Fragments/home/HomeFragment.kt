package com.myself223.card.Fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.myself223.card.App
import com.myself223.card.R
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), HomeAdapter.Result {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initOnBoard()
        initAdapter()
        binding.btnAdd.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key", "category")
            findNavController().navigate(R.id.addCategoryFragment, bundle)
        }
    }

    private fun initAdapter() {
        adapter = HomeAdapter(this)
        adapter.setList(App.database.getDao().getAllCard())
        binding.rvMain.adapter = adapter
    }

    fun initOnBoard() {
        if (!App.prefs.isShow()) {
            App.prefs.changeShow(true)
            findNavController().navigate(R.id.onBoardFragment)
        }
    }

    override fun OnClick(pos: Int, list: List<CardModel>) {
        val bundle  = Bundle()
        val cat = ArrayList(list)
        bundle.putSerializable("list", cat)
        bundle.putInt("pos", pos)
        findNavController().navigate(R.id.categoryFragment, bundle)
    }
}