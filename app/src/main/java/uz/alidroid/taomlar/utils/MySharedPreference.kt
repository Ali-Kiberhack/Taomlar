package uz.alidroid.taomlar.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.alidroid.taomlar.Models.Myfood

object MySharedPreference {
    private const val NAME="catch_file_name"
    private const val MODE=Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences
    fun init(context: Context){
        preferences=context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor)->Unit){
        val editor=edit()
        operation(editor)
        editor.apply()
    }

   var list:ArrayList<Myfood>

    get()= stringToList(preferences.getString("list","[]")!!)
    set(value) = preferences.edit{
        if (value!=null){
            it.putString("list", listToString(value))
        }
    }
    fun stringToList(str:String): ArrayList<Myfood> {
        val gson =Gson()
        val list =ArrayList<Myfood>()


        val type=object :TypeToken<ArrayList<Myfood>>(){}.type
        list.addAll(gson.fromJson(str,type))

        return list
    }

    fun listToString(list: ArrayList<Myfood>):String{
        return Gson().toJson(list)
    }
}