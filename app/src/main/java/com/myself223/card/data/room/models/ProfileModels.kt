package com.myself223.card.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class ProfileModels (
    var id: Int? = null,
    val name: String,
    @ColumnInfo(name = "Email")
    val email: String,
)
