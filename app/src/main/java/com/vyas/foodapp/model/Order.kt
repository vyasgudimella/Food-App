package com.vyas.foodapp.model

import com.vyas.foodapp.model.OrderItem


data class Order (
    val restaurantName : String,
    val orderDate: String,
    val itemList : ArrayList<OrderItem>
)