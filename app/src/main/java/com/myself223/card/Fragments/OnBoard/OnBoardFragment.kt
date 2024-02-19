package com.myself223.card.Fragments.OnBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.myself223.card.databinding.FragmentOnBoard2Binding
import com.myself223.card.MainActivity
import com.myself223.card.R
import com.myself223.card.data.room.models.CardModel

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoard2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoard2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter(this)
        binding.viwePager2.adapter = adapter



    }
    fun OnClick(position: Int) {
        findNavController().navigate(R.id.categoryFragment)

    }


}
