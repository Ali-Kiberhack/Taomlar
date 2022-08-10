package uz.alidroid.taomlar.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*
import uz.alidroid.taomlar.Models.Myfood
import uz.alidroid.taomlar.R
import uz.alidroid.taomlar.utils.MySharedPreference

class InfoActivity : AppCompatActivity() {

    private  lateinit var myfood: Myfood
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val index=intent.getIntExtra("keyIndex",0)
        MySharedPreference.init(this)

        myfood=MySharedPreference.list[index]

        tv_name.text=myfood.name
        tv_mahsulot.text=myfood.kerakliMahsulotlar
        tv_tayyorlash.text=myfood.tayyorlashTartibi
    }
}