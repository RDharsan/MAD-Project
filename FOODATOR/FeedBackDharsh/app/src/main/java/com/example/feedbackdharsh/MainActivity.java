package com.example.feedbackdharsh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //feedback Dharsan
    System.out.println("hhdhd");
    //hbhbvhhvv
    FeedbackDBhelper myDB;
    TextView rateview;
    EditText txtname, txtfeedback,btnedit3;
    RatingBar ratebar;
    Button btnSendfb, btnView,btnedit, btndelete,viewMine;
    public String myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new FeedbackDBhelper(this);

        txtname = (EditText) findViewById(R.id.name);
        ratebar = findViewById(R.id.rateus);
        txtfeedback = (EditText) findViewById(R.id.typeFeedback);


        btnSendfb = (Button) findViewById(R.id.sendbtn);
        btnView = (Button) findViewById(R.id.viewbtn);
        btndelete=(Button)findViewById(R.id.deletebtn);
        viewMine=(Button)findViewById(R.id.viewmy);
        rateview=findViewById(R.id.rateview);


        AddData();
        showView();
        delete();
        viewmy();
        viewAvgRate();



    }

    public void viewAvgRate(){
        Cursor d=myDB.calaverageRate();
        StringBuilder stringBuilder=new StringBuilder();
        while(d.moveToNext()){
            stringBuilder.append("Average Rate : "+ d.getFloat(0));
        }

        rateview.setText(stringBuilder);
    }
    public void viewmy(){
        viewMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Viewmine.class);
                startActivity(intent);

            }
        });
    }

    public void delete(){
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("DELETE FEEDBACK?\nEnter the feedback number!!");

                final EditText intext= new EditText(MainActivity.this);
                intext.setInputType(InputType.TYPE_CLASS_NUMBER);
                mydialog.setView(intext);

                mydialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myText=intext.getText().toString();
                        Integer deleterow=myDB.deleteData(myText);
                        if(deleterow > 0){
                            Toast.makeText(MainActivity.this, "Your feedback Deleted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Deletion failed!", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.show();
            }
        });
    }




    public void showView() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), com.example.feedbackdharsh.View.class);
                //intent.putExtra("EXTRA_NAME", txtname.getText().toString());
                startActivity(intent);
            }
        });


    }

    public void AddData() {
        btnSendfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratebar.getRating());
                if (txtname.getText().toString().equals("") || txtfeedback.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill the form!!!", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = myDB.insertFeedback(txtname.getText().toString(), s, txtfeedback.getText().toString());
                    if (isInserted == true) {

                        Toast.makeText(MainActivity.this, "Thank you for your feedbacks\n And " + s + " Stars!!", Toast.LENGTH_SHORT).show();

                        Cursor res = myDB.getViewData();
                        StringBuffer stringBuffer = new StringBuffer();
                        while (res.moveToNext()) {
                            stringBuffer.append("Your Feedback Number is : " + res.getString(0));
                        }

                        showMessage("Feedback", stringBuffer.toString());
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to send!!", Toast.LENGTH_SHORT).show();

                    }
                    Handler handler= new Handler();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            finish();
                            startActivity(getIntent());
                        }
                    }, 4000);

                }

            }


        });


    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
<<<<<<< HEAD

//hcybyee
=======
//dashhhhhhh mari oru mana nilamai
>>>>>>> c4d0800f78b64b71e3d7dac2b9ff921a55852e6a
