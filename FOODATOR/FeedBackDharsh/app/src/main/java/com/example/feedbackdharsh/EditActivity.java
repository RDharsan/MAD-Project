package com.example.feedbackdharsh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    FeedbackDBhelper myDB;
    EditText name2,feedback2, editId;
    RatingBar rate2;
    Button updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        myDB = new FeedbackDBhelper(this);
        name2 = (EditText) findViewById(R.id.name2);
        rate2 = findViewById(R.id.rateus2);
        editId=(EditText)findViewById(R.id.fdid);
        feedback2 = (EditText) findViewById(R.id.typeFeedback2);
        updatebtn = (Button) findViewById(R.id.updatebtn);
        UpdateData();
    }
    public void UpdateData(){
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(rate2.getRating());
                boolean isUpdated= myDB.updateData(editId.getText().toString(), name2.getText().toString(),s, feedback2.getText().toString());

                if(isUpdated == true){
                    Toast.makeText(EditActivity.this, "Feedback Updated. Thank you !!!", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(EditActivity.this, "Ooooopppppsss! Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}

//Anubama Logaratnam