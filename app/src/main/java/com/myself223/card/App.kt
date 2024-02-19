package com.myself223.card

import   android.app.Application
import androidx.room.Room
import com.myself223.card.data.room.CardDatabase
import com.myself223.card.data.shared.Prefs

class App:Application() {


    companion object {
        lateinit var prefs: Prefs
        lateinit var database: CardDatabase

    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(this)
        database = Room.databaseBuilder(
            this,
            CardDatabase::class.java,
            "Room Android"
        ).allowMainThreadQueries().build()
    }
}