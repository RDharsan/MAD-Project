package com.example.foodatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnNext = (Button)findViewById(R.id.button);
        AddData();











    }

    public void AddData() {
        btnNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openActivity_reservation_form2();

                    }
                }
        );
    }

    public void openActivity_reservation_form2() {
        Intent intent = new Intent(this,reservation2.class);
        startActivity(intent);
    }

}