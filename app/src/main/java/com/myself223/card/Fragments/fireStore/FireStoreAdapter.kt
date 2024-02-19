package com.myself223.card.Fragments.fireStore

import FireStoreModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.databinding.FragmentItemFireStoreBinding

class FireStoreAdapter: RecyclerView.Adapter<FireStoreAdapter.FireStoreViewHolder>() {


    private val list = ArrayList<FireStoreModel>()


    fun stList(model: List<FireStoreModel>) {
        this.list.addAll(model)
        notifyDataSetChanged()

    }

    inner class FireStoreViewHolder(private val binding: FragmentItemFireStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.txtText.text = list[pos].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FireStoreViewHolder {
         return FireStoreViewHolder(
             FragmentItemFireStoreBinding.inflate(
                 LayoutInflater.from(parent.context),
                 parent,
                 false

             )

         )
    }

    override fun getItemCount() = list.size



    override fun onBindViewHolder(holder: FireStoreAdapter.FireStoreViewHolder, position: Int) {
       holder.onBind(position)
    }


}




