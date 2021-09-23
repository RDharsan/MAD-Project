package com.example.feedbackdharsh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.icu.util.Measure;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class View extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        FeedbackDBhelper myDB=new FeedbackDBhelper(this);

        TextView textView= findViewById(R.id.viewfeedback);
        Cursor cursor= myDB.ViewData();
        if(cursor.getCount()==0){
            showMessage("Oooppsss", "Nothing found here..");
            return;
        }

        StringBuilder stringBuilder= new StringBuilder();
        while(cursor.moveToNext()){
            //stringBuilder.append("ID\t\t\t\t\t\t\t\t\t: " + cursor.getString(0)+"\n");
            stringBuilder.append("Name\t\t\t\t\t\t\t\t: " + cursor.getString(1)+"\n");
            stringBuilder.append("Rate\t\t\t\t\t\t\t\t\t\t: " + cursor.getString(2)+"\n");
            stringBuilder.append("Feedbacks\t\t: " + cursor.getString(3)+ "\n\n");

        }

        textView.setText(stringBuilder);
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}