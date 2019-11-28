package com.rjt.organikagrocers.Class

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SessionManager {

    var LOGGED_IN_PREF: String = "logged_in_status"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)

    }

    fun setLoggedIn(context: Context, loggedIn: Boolean){
        var editor: SharedPreferences.Editor = getSharedPreferences(context).edit()
        editor.putBoolean(LOGGED_IN_PREF, loggedIn)

        editor.apply()


    }

    fun getLoggedStatus(context: Context): Boolean{
        return getSharedPreferences(context).getBoolean(LOGGED_IN_PREF, false)
    }

    fun setLogOut(context: Context){
        var editor: SharedPreferences.Editor = getSharedPreferences(context).edit()
        editor.clear()
        editor.commit()
    }
}