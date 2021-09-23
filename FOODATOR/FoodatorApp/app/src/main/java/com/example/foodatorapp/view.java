package com.example.foodatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class view extends AppCompatActivity {
    Button b4;
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        SQLiteDatabase db = openOrCreateDatabase("Foodator", Context.MODE_PRIVATE,null);

        lst1 = findViewById(R.id.lst1);
        final Cursor c = db.rawQuery("select * from records",null);
        int id = c.getColumnIndex("id");
        int name = c.getColumnIndex("name");
        int phone = c.getColumnIndex("phone");
        int mail = c.getColumnIndex("mail");
        int address = c.getColumnIndex("address");
        titles.clear();


        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final  ArrayList<contact> cont = new ArrayList<contact>();


        if(c.moveToFirst())
        {
            do{
                contact con = new contact();
                con.id = c.getString(id);
                con.name = c.getString(name);
                con.phone = c.getString(phone);
                con.mail = c.getString(mail);
                con.address = c.getString(address);
                cont.add(con);

                titles.add(c.getString(id) + " \t " + c.getString(name) + " \t "  + c.getString(phone) + " \t "  + c.getString(mail) + " \t "  + c.getString(address) );

            } while(c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();



        }

        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aa = titles.get(position).toString();
                contact con = cont.get(position);
                Intent i = new Intent(getApplicationContext(),edit.class);
                i.putExtra("id",con.id);
                i.putExtra("name",con.name);
                i.putExtra("phone",con.phone);
                i.putExtra("mail",con.mail);
                i.putExtra("address",con.address);
                startActivity(i);

            }
        });






}
}