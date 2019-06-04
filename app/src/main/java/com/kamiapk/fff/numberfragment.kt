package com.kamiapk.fff

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_numberfragment.*




//動的に配置する際に呼び出される。引数を取るためには必要
fun new_numberfragment(num :Int) : numberfragment{

    //fragmentにnumberfragmentクラスを代入
    val fragment = numberfragment()

    //Bundleを用意
    val args = Bundle()
    //intentと同じ要領で引数を入れる
    args.putInt("display_number",num)

    //フラグメントの引数(arguments)に代入
    fragment.arguments = args

    //numberfragmentを返す
    return fragment

}


class numberfragment : Fragment() {

    private var display_num = 0

    private lateinit var nm : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //引数の取り出し
        //引数がnullの場合はエルビス演算子を用いて0を入れる
        display_num = savedInstanceState?.getInt("display_number")
                    ?: arguments?.getInt("display_number") ?: 0
    }

    //アクティビティのonCreate()と大体同じ
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //テキストの更新
        val view = inflater.inflate(R.layout.fragment_numberfragment, container, false)

        nm = view.findViewById(R.id.number)
        nm.text = display_num.toString()
        return view
    }


    //画面回転などでフラグメントが停止したときに呼ばれる。
    //これにより再生成したときに値の初期化を防ぐことができる
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("display_number",display_num)
        //値が保存されたらフラグメントが再生成されるのでonCreateで値を取得しなおす。
    }




    //buttonfragmentのボタンがタップされた時の処理
    fun number_low(){
        display_num += 1
        nm.text = ( display_num.toString())
    }
    fun number_high() {
        display_num += 100
        nm.text = display_num.toString()
    }


}


