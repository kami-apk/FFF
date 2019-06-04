package com.kamiapk.fff


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_buttonfragment.*


class buttonfragment : Fragment() {

    //コールバックインターフェイスを定義
    interface onButtonClickListener{
        fun onButtonClick_low()
        fun onButtonClick_high()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_buttonfragment, container, false)
        //各ボタンがタップされたときのリスナーをセット

        view.findViewById<Button>(R.id.high).setOnClickListener {
            //コールバックインターフェイスを実装しているアクティビティにイベントを知らせる。
            val listener = context as onButtonClickListener
            listener?.onButtonClick_high()
        }

        view.findViewById<Button>(R.id.low).setOnClickListener {
            val listener = context as onButtonClickListener
            listener?.onButtonClick_low()
        }



        /*
        low.setOnClickListener {
            val listener = context as onButtonClickListener
            listener?.onButtonClick_low()
        }

        high.setOnClickListener {
            val listener = context as onButtonClickListener
            listener?.onButtonClick_high()
        }
        */
        return view
    }



}
