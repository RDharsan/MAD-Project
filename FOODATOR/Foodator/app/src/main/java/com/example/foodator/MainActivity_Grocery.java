package com.example.foodator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodator.Adapters.MainAdapter_Grocery;
import com.example.foodator.Models.MainModel;
import com.example.foodator.databinding.ActivityMainGroceryBinding;

import java.util.ArrayList;

public class MainActivity_Grocery extends AppCompatActivity {


    ActivityMainGroceryBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainGroceryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.apple ,"APPLE", "207","APPLE with Guaranteed hygiene, quality and freshness  300g(s)"));
        list.add(new MainModel(R.drawable.orange ,"ORANGE", "258","ORANGE with Guaranteed hygiene, quality and freshness  300g(s)"));
        list.add(new MainModel(R.drawable.banana ,"BANANA", "210","BANANA with Guaranteed hygiene, quality and freshness 500g(s)"));
        list.add(new MainModel(R.drawable.grapes ,"GRAPES", "459","GRAPES with Guaranteed hygiene, quality and freshness 300g(s)"));
        list.add(new MainModel(R.drawable.lemon ,"LEMON", "322","LEMON with Guaranteed hygiene, quality and freshness 500g(s)"));
        list.add(new MainModel(R.drawable.pears ,"PEARS", "300","PEARS with Guaranteed hygiene, quality and freshness 500g(s)"));
        list.add(new MainModel(R.drawable.papaya ,"PAPAYA", "270","PAPAYA with Guaranteed hygiene, quality and freshness 1kg"));
        list.add(new MainModel(R.drawable.straberry ,"STRAWBERRIES", "600","STRAWBERRIES with Guaranteed hygiene, quality and freshness 250g(s)"));
        list.add(new MainModel(R.drawable.butter ,"BUTTER", "460","BUTTER with Creamery Salted Butter 200g(s)"));
        list.add(new MainModel(R.drawable.milk ,"MILK", "280","MILK with Fresh and hygienic 1L"));
        list.add(new MainModel(R.drawable.egg ,"EGG", "335","EGG with Brown Egg Extra Large 10(s)"));
        list.add(new MainModel(R.drawable.cheese ,"CHEESE", "335","CHEESE with Quality and fresh Cow Cheese 250g(s)"));
        list.add(new MainModel(R.drawable.bread ,"BREAD", "335","BREAD with Hygienic Sliced Bread 200g(s)"));
        list.add(new MainModel(R.drawable.salt ,"SALT", "140","SALT with Guaranteed quality Table Salt 1kg"));
        list.add(new MainModel(R.drawable.sugar ,"SUGAR", "190","SUGAR with Guaranteed quality white Sugar 1kg"));
        list.add(new MainModel(R.drawable.pepper ,"PEPPER", "335","PEPPER with Guaranteed quality Pepper Powder 250g(s)"));
        list.add(new MainModel(R.drawable.broccoli ,"BROCCOLI", "999","BROCCOLI Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.cucumber ,"CUCUMBER", "150","CUCUMBER Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.carrot ,"CARROT", "100","CARROT Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.garlic ,"GARLIC", "190","GARLIC Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.tomatos ,"TOMATO", "120","TOMATO Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.onion ,"ONION", "120","ONION Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.potatos ,"POTATO", "125","POTATO Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.beetrrot ,"BEETROOT", "178","BEETROOT Fresh and hygienic 500g(s)"));
        list.add(new MainModel(R.drawable.redpepper ,"RED CHILLI", "635","RED CHILLI Fresh and hygienic 1kg"));
        list.add(new MainModel(R.drawable.beef,"BEEF", "1300","BEEF Fresh and hygienic 1kg"));
        list.add(new MainModel(R.drawable.fish ,"FISH", "800","FISH Fresh and hygienic 1kg"));
        list.add(new MainModel(R.drawable.chicken ,"CHICKEN", "1100","CHICKEN Fresh and hygienic 1kg"));

        MainAdapter_Grocery adapter = new MainAdapter_Grocery(list, this);
        binding.recylerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_grocery, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity_Grocery.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}