package com.myself223.card.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.myself223.card.data.room.converter.Converter
import java.io.Serializable
import java.util.Locale

@Entity(tableName = "cards")
data class CardModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    @TypeConverters(Converter::class)
    var list: List<CategoryModel>
    ):Serializable