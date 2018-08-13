package com.kad.goodsmodule.fragment


import android.os.Bundle
import android.app.Fragment
import android.view.View
import com.kad.basemodule.BaseFragment

import com.kad.goodsmodule.R
import com.kad.routermodule.util.CoreServiceManager
import kotlinx.android.synthetic.main.goods_fragment_layout.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GoodsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GoodsFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun getLayoutId(): Int {
        return R.layout.goods_fragment_layout
    }

    override fun initView(view: View) {

        val cartService = CoreServiceManager.instance.iCartService
        btn_go_cart.setOnClickListener{
            cartService!!.goCart()
        }
    }

    override fun initData() {

    }

    override fun getPageArguments() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GoodsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GoodsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
