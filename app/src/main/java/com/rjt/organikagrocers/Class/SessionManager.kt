package com.rjt.organikagrocers.Class

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SessionManager {

    var LOGGED_IN_AUTH: String = "logged_in_auth"
    var LOGGED_IN_STATUS: String = "logged_in_status"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)

    }

    fun setLoggedIn(context: Context, authToken: String, loggedStatus: Boolean){
        var editor: SharedPreferences.Editor = getSharedPreferences(context).edit()
        editor.putString(LOGGED_IN_AUTH, authToken)
        editor.putBoolean(LOGGED_IN_STATUS, loggedStatus)

        editor.apply()


    }

    fun getLoggedStatus(context: Context): Boolean{
        return getSharedPreferences(context).getBoolean(LOGGED_IN_STATUS, false)
    }

    fun setLogOut(context: Context, loggedStatus: Boolean){
        var editor: SharedPreferences.Editor = getSharedPreferences(context).edit()

        editor.putBoolean(LOGGED_IN_STATUS, false)
        editor.clear()
        editor.commit()
    }
}