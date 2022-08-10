package uz.alidroid.taomlar.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_all_foods2.*
import uz.alidroid.taomlar.Models.Myfood
import uz.alidroid.taomlar.R
import uz.alidroid.taomlar.adapters.MyFoodAdapter
import uz.alidroid.taomlar.utils.MySharedPreference

class AllFoodsActivity : AppCompatActivity() {

       private  lateinit var list: ArrayList<Myfood>
       private  lateinit var myFoodAdapter: MyFoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_foods2)

        MySharedPreference.init(this)
        list=MySharedPreference.list

        myFoodAdapter= MyFoodAdapter(list,this)
        list_view_foods.adapter=myFoodAdapter

        list_view_foods.setOnItemClickListener { adapterView, view, i, l ->

            val intent=Intent(this,InfoActivity::class.java)
            intent.putExtra("keyIndex",i)
            startActivity(intent)
        }

    }
}