package com.myself223.card.Fragments.OnBoard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.R
import com.myself223.card.data.room.models.CardModel
import com.myself223.card.databinding.ItemOnBoardBinding

class OnBoardAdapter(private val click:OnBoardFragment) : RecyclerView.Adapter<OnBoardAdapter.BoardViewHolder>() {
    lateinit var navController: NavController
    private val img = listOf(
        R.drawable.img_2,
        R.drawable.img,
        R.drawable.img_1

    )
    private val title = listOf(
        "ЧУХАНИ ПИСЮНЧИК!",
        "Я ПРИЕМНЫЙ",
        "ЛИСТАНИ ЕСЛИ ГЕЙ!"
    )
    private val desc = listOf(
        "ВАШИ РОДИТЕЛИ СЛУЧАЙНО НЕ ПИРАТЫ?",
        "СЕРЬЕЗНО ПОСМОТРИТЕ КАРТИНКУ СВЕРХУ",
        "И ПРОЧИТАЙ ЭТО ЕСЛИ ГЕЙ"
    )
    inner class  BoardViewHolder( val binding: ItemOnBoardBinding):
        RecyclerView.ViewHolder(binding.root){



            fun onBind(position:Int){
                binding.btnGoToReg.setOnClickListener{


                }
                binding.bot.setImageResource(img[position])
                binding.textTitle.text = title[position]
                binding.desc.text = desc[position]
                if (position == 1){
                    binding.btnGoToReg.visibility = View.VISIBLE
                }
                if (position == 2) {
                    binding.btnGoToReg.visibility = View.VISIBLE
                } else{
                    binding.btnGoToReg.visibility = View.INVISIBLE

                }

            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )

    }

    override fun onBindViewHolder(holder: BoardViewHolder, position:Int) {
        holder.onBind(position)
        holder.itemView.setOnClickListener {
            click.OnClick(position)
        }
    }

    override fun getItemCount() = img.size



    interface Result {
        fun OnClick(pos: Int)
    }
}