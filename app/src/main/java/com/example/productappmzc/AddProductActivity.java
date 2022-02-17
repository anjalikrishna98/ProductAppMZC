package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1,b2;
String getPrdcode,getPrdname,getPrice;
DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ed1=(EditText) findViewById(R.id.prdcode);
        ed2=(EditText) findViewById(R.id.prdname);
        ed3=(EditText) findViewById(R.id.price);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.backtomenu);
        dbHelper=new DbHelper(this);
        dbHelper.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrdcode = ed1.getText().toString();
                getPrdname = ed2.getText().toString();
                getPrice = ed3.getText().toString();

                boolean result = dbHelper.insert(getPrdcode, getPrdname, getPrice);
                if (result == true) {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "succesfully inserted", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "failed to insert", Toast.LENGTH_SHORT).show();
                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

}