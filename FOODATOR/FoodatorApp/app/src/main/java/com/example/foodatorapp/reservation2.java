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

public class reservation2 extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation2);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.mail);
        ed4 = findViewById(R.id.address);
        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(),view.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getApplicationContext(),success.class);
                startActivity(j);
                insert();
            }
        });
    }

    public void insert()
    {
        try
        {
            String name = ed1.getText().toString();
            String phone = ed2.getText().toString();
            String mail = ed3.getText().toString();
            String address = ed4.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("Foodator", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS records(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,phone VARCHAR,mail VARCHAR,address VARCHAR)");

            String sql = "insert into records(name,phone,mail,address)values(?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,name);
            statement.bindString(2,phone);
            statement.bindString(3,mail);
            statement.bindString(4,address);
            statement.execute();
            Toast.makeText(this,"Record addded",Toast.LENGTH_LONG).show();

            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }
}