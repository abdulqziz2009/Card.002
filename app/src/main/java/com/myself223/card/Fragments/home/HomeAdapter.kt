package com.myself223.card.Fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.databinding.ItemCategoriBinding

class HomeAdapter(
    private val click: Result
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val list = ArrayList<CardModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CardModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    inner class HomeViewHolder(private val binding: ItemCategoriBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.txtName.text = list[pos].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemCategoriBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(position)
        holder.itemView.setOnClickListener {
            click.OnClick(position, list)
        }
    }


    interface Result {
        fun OnClick(pos: Int, list: List<CardModel>)
    }
}