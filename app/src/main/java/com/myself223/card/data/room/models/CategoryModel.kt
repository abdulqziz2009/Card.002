package com.myself223.card.data.room.models

import androidx.room.TypeConverters
import com.myself223.card.data.room.converter.Converter
import java.io.Serializable



data class CategoryModel(
    val name: String,
    val image: String,
): Serializable



