package com.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bill extends AppCompatActivity {

    TextView t2, t3, t4, t5, t6, t7, t8, t9;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        btnsubmit = findViewById(R.id.btnsubmit);

        t2.setText("Name : " + getIntent().getStringExtra("pname"));
        t3.setText("Address : " + getIntent().getStringExtra("add"));
        t4.setText("Email : " + getIntent().getStringExtra("email"));
        t5.setText("Contact Number : " + getIntent().getStringExtra("phn"));
        t6.setText("Book Name : " + getIntent().getStringExtra("bname"));
        t7.setText("Price : " + getIntent().getStringExtra("price"));
        t8.setText("Quantity : " + getIntent().getStringExtra("quantity"));
        t9.setText("Total Amount : " + getIntent().getStringExtra("totalamount"));

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}