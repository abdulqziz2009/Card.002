package com.myself223.card.data.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myself223.card.data.room.models.CategoryModel

class Converter {

    @TypeConverter
    fun fromGroupTaskMemberList(value: List<CategoryModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): List<CategoryModel> {
        val gson = Gson()
        val type = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.fromJson(value, type)
    }
}