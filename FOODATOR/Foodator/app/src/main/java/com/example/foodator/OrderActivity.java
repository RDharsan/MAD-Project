package com.example.foodator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodator.Adapters.OrdersAdapter_Grocery;
import com.example.foodator.Models.groceryOrdersModel;
import com.example.foodator.databinding.ActivityOrderGroceryBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderGroceryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderGroceryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper_Grocery helper = new DBHelper_Grocery(this);
        ArrayList<groceryOrdersModel> list = helper.getOrders();

        OrdersAdapter_Grocery adapter = new OrdersAdapter_Grocery(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);
    }
}