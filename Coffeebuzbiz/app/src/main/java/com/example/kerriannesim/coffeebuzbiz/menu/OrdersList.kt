package com.example.kerriannesim.coffeebuzbiz.com.example.kerriannesim.coffeebuzbiz.menu

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.example.kerriannesim.coffeebuzbiz.R
import com.example.kerriannesim.coffeebuzbiz.menu.NewCustomerFragment
import android.widget.ArrayAdapter
import com.example.kerriannesim.coffeebuzbiz.R.id.container
import android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.kerriannesim.coffeebuzbiz.com.example.kerriannesim.coffeebuzbiz.SwipeController






class NewOrderListFragment : Fragment() {

    companion object {

        fun newInstance(): NewOrderListFragment {
            return NewOrderListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.orders_list, container,
            false)

        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(getActivity())

        val swipeController = SwipeController()
        val itemTouchhelper = ItemTouchHelper(swipeController)
        itemTouchhelper.attachToRecyclerView(recyclerView)

        val orders = arrayListOf("Flat White", "Latte", "Mocha", "Flat White")
        val ordersAdapter = OrderAdapter(orders, context as Context)

        recyclerView.adapter = ordersAdapter
        return view
    }


}