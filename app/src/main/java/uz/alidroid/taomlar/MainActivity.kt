package uz.alidroid.taomlar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.alidroid.taomlar.ui.AddFoodActivity
import uz.alidroid.taomlar.ui.AllFoodsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       btn_taomlar.setOnClickListener{
           val intent = Intent(this,AllFoodsActivity::class.java)
           startActivity(intent)
       }

        btn_add_food.setOnClickListener{
            val intent = Intent(this,AddFoodActivity ::class.java)
            startActivity(intent)
        }
    }
}