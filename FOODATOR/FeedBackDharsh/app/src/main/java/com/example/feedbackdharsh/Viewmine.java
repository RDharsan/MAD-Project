package com.example.feedbackdharsh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Viewmine extends AppCompatActivity {
    EditText id;
    Button submit,btnedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmine);

        FeedbackDBhelper myDB=new FeedbackDBhelper(this);
        id=(EditText) findViewById(R.id.idV);
        submit=(Button) findViewById(R.id.sub);
        btnedit=(Button)findViewById(R.id.editbtn2);
        moveEdit();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id=id.getText().toString();
                TextView textView= findViewById(R.id.viewmine1);
                Cursor cursor= myDB.ViewMyData(Id);
                if(cursor.getCount()==0){
                    showMessage("Oooppsss", "Nothing found here..");
                    return;
                }

                StringBuilder stringBuilder = new StringBuilder();
                while (cursor.moveToNext()) {
                //stringBuilder.append("ID\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t: " + cursor.getString(0) + "\n");
                stringBuilder.append("Name\t\t\t\t\t\t\t\t\t: " + cursor.getString(1) + "\n");
                stringBuilder.append("Rate\t\t\t\t\t\t\t\t\t\t\t: " + cursor.getString(2) + "\n");
                stringBuilder.append("Feedbacks\t\t: " + cursor.getString(3) + "\n");

                }

                textView.setText(stringBuilder);

            }
        });

    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void moveEdit(){
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), EditActivity.class);
                startActivity(intent);
            }
        });
    }



}