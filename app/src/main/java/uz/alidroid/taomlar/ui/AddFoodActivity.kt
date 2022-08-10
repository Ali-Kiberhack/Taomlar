package uz.alidroid.taomlar.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_food.*
import uz.alidroid.taomlar.Models.Myfood
import uz.alidroid.taomlar.R
import uz.alidroid.taomlar.utils.MySharedPreference

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        MySharedPreference.init(this)

        btn_save.setOnClickListener{
            val name =edt_name.text.toString().trim()
            val km =edt_mahsulot.text.toString().trim()
            val tt =edt_tayyorlash.text.toString().trim()


            if (name!=""&& km!=""&& tt!=""){

                val myFood=Myfood(name,km,tt)
                val list= MySharedPreference.list
                list.add(myFood)
                MySharedPreference.list=list
                Toast.makeText(this,"Saqalandi", Toast.LENGTH_SHORT).show()
                finish()

            }else{

                Toast.makeText(this,"Ma'lumotni to'liq kiriting", Toast.LENGTH_SHORT).show()
            }



        }
    }
}