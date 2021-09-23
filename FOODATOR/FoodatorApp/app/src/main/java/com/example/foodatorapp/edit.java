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


public class edit extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.mail);
        ed4 = findViewById(R.id.address);
        ed5 = findViewById(R.id.id);

        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);


        Intent i = getIntent();

        String t1 = i.getStringExtra("id").toString();
        String t2 = i.getStringExtra("name").toString();
        String t3 = i.getStringExtra("phone").toString();
        String t4 = i.getStringExtra("mail").toString();
        String t5 = i.getStringExtra("address").toString();

        ed5.setText(t1);
        ed1.setText(t2);
        ed2.setText(t3);
        ed3.setText(t4);
        ed4.setText(t5);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete();
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),view.class);
                startActivity(i);

            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit();
            }
        });

    }

    public void Delete()
    {
        try
        {
            String id = ed5.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("Foodator", Context.MODE_PRIVATE,null);


            String sql = "delete from records where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Record Deleted",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);


            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();


        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }
    public void Edit()
    {
        try
        {
            String name = ed1.getText().toString();
            String phone = ed2.getText().toString();
            String mail = ed3.getText().toString();
            String address = ed4.getText().toString();
            String id = ed5.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("Foodator",Context.MODE_PRIVATE,null);


            String sql = "update records set name = ?,phone=?,mail=?,address=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,name);
            statement.bindString(2,phone);
            statement.bindString(3,mail);
            statement.bindString(4,address);
            statement.bindString(5,id);
            statement.execute();
            Toast.makeText(this,"Record Updated",Toast.LENGTH_LONG).show();


            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();


        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }

    }

}