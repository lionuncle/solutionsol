package com.lionuncle.solutionsol

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class Repository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()


    fun addNewItem(text: String, context: Context){

        addToFirebase(text)
        addToSharedPref(text, context)
    }
    private fun addToFirebase(text: String){
        db.collection("Products").add(text).addOnSuccessListener {
            Log.i("data", "added ${text} to firestore")
        }
    }
    private fun addToSharedPref(text: String,context: Context){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(text, text).apply();
    }
    fun getNumber(context: Context): Int{
        val text = "Product "
        var total = 0
        var check = ""
        var i = 1
        while ( check != ""){
            check = PreferenceManager.getDefaultSharedPreferences(context).getString(text+i, "")!!
            if (check != ""){
                total++
            }
            i++
        }
        return total
    }

}