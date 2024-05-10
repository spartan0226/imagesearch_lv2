package com.sparta.fifth

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {

    private const val PREF_NAME = "SearchPref"
    private const val SEARCH_WORD = "last_search_query"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun gotSearched(context: Context, query: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(SEARCH_WORD, query)
        editor.apply()
    }

    fun setSearched(context: Context): String? {
        return getSharedPreferences(context).getString(SEARCH_WORD, null)
    }
}