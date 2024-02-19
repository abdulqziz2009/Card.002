package com.myself223.card.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.myself223.card.data.room.models.CardModel

@Dao
interface Dao {

    @Query("SELECT * FROM cards")
    fun getAllCard(): List<CardModel>
    @Insert
    fun insertCard(model: CardModel)
    @Update
    fun updateCard(model: CardModel)



}