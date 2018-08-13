package com.kad.mainmodule



import android.support.v4.app.Fragment
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.kad.basemodule.BaseActivity
import com.kad.routermodule.util.ReflectUtils

class MainActivity : BaseActivity() {



    private var list:MutableList<Fragment?>  = ArrayList()


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        println("----initMainView----")

        val indexFragment = ReflectUtils.getFragment("com.kad.mainmodule.fragment.IndexFragment")
        val cartFragment = ReflectUtils.getFragment("com.kad.cartmodule.fragment.CartFragment")
        val goodsFragment = ReflectUtils.getFragment("com.kad.goodsmodule.fragment.GoodsFragment")
        val userFragment = ReflectUtils.getFragment("com.kad.usermodule.fragment.UserFragment")

        findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.bottom_home -> changeFragmentShow(0)
                R.id.bottom_sort -> changeFragmentShow(1)
                R.id.bottom_cart -> changeFragmentShow(2)
                R.id.bottom_user -> changeFragmentShow(3)
            }
        }

        if(indexFragment==null||cartFragment==null || goodsFragment==null||userFragment == null){
            Toast.makeText(this,"业务主见为Null",Toast.LENGTH_SHORT).show()
        }else{
            list.add(indexFragment)
            list.add(goodsFragment)
            list.add(cartFragment)
            list.add(userFragment)

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.flt_content,indexFragment,indexFragment.javaClass.simpleName)
            fragmentTransaction.add(R.id.flt_content,goodsFragment,goodsFragment.javaClass.simpleName)
            fragmentTransaction.add(R.id.flt_content,cartFragment,cartFragment.javaClass.simpleName)
            fragmentTransaction.add(R.id.flt_content,userFragment,userFragment.javaClass.simpleName)
            fragmentTransaction.commit()
            showHome()
        }




    }

    override fun initData() {
        println("----initMainData----")
    }



    fun showHome(){
        findViewById<RadioButton>(R.id.bottom_home).isChecked = true
        changeFragmentShow(0)
    }

    fun changeFragmentShow(position:Int){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        for (index in list!!.indices){
            if(index == position){
                fragmentTransaction.show(list!![index])
            }else{
                fragmentTransaction.hide(list!![index])
            }
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}
