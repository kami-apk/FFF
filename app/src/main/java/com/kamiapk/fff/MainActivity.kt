package com.kamiapk.fff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.fragment_numberfragment.*

class MainActivity : AppCompatActivity(),buttonfragment.onButtonClickListener {  //コールバックインターフェイスを忘れない

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ナンバーフラグメントはフラグメントの生成時に引数を渡したいので動的に配置する。
        if (supportFragmentManager.findFragmentByTag("ttt") == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frag, new_numberfragment(0), "ttt")
                .commit()
        }

    }

    //値を更新したあと、一秒間スレッドを用いてメソッドが終了するのを遅らせる
    override fun onButtonClick_low() {
        Log.d("A","1")
        val fragment = supportFragmentManager.findFragmentByTag("ttt") as numberfragment
        fragment.number_low()
        Thread.sleep(1000)
        Log.d("A","2")
    }


    override fun onButtonClick_high() {
        Log.d("B","1")
        val fragment = supportFragmentManager.findFragmentByTag("ttt") as numberfragment
        fragment.number_high()
        Thread.sleep(1000)
        Log.d("B","2")
    }

}
