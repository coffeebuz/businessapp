package com.example.kerriannesim.coffeebuzbiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_orders.*

class Orders : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val orderList = arrayListOf<String>("10", "20", "30", "40", "50")

        rv_OrdersList.layoutManager = LinearLayoutManager(this)

        rv_OrdersList.adapter = OrdersAdapter(orderList, this)


    }
}
