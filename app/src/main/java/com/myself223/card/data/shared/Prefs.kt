package com.myself223.card.data.shared

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(context: Context) {

    private val prefs = context.getSharedPreferences("prefs" , MODE_PRIVATE)

    fun isShow(): Boolean{
        return prefs.getBoolean("onBoard" , false)

    }
    fun changeShow(show :Boolean){
        prefs.edit().putBoolean("onBoard",show).apply()
    }
    fun saveName(name:String){
        prefs.edit().putString("name",name).apply()
    }
    fun showName():String{
        return prefs.getString("name","Net invalida").toString()
    }
    fun saveEmail(email:String){
        prefs.edit().putString("email",email).apply()
    }
    fun showEmail():String{
        return prefs.getString("email","Nekuda soboleznovat").toString()
    }
    fun isShow2(): Boolean{
        return prefs.getBoolean("onRegister" , false)

    }
    fun changeShow2(show :Boolean){
        prefs.edit().putBoolean("onRegister",show).apply()
    }
}
