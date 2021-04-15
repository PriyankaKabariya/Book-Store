package com.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FillDetail extends AppCompatActivity {

    Button btnbill;
    EditText txtname, txtadd, txtemail, txtphn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_detail);

        btnbill = findViewById(R.id.btnbill);
        txtname = findViewById(R.id.txtname);
        txtadd = findViewById(R.id.txtadd);
        txtemail = findViewById(R.id.txtemail);
        txtphn = findViewById(R.id.txtphn);

        btnbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtname.getText().toString().trim().length() == 0) {
                    txtname.setError("Please enter name");
                }
                if (txtadd.getText().toString().trim().length() == 0) {
                    txtadd.setError("Please enter address");
                }
                if (txtemail.getText().toString().trim().length() == 0) {
                    txtemail.setError("Please enter email");
                }
                if (txtphn.getText().toString().trim().length() == 0) {
                    txtphn.setError("Please enter contact number");
                }
                if (txtname.getText().toString().trim().length() != 0 &&
                        txtadd.getText().toString().trim().length() != 0 &&
                        txtemail.getText().toString().trim().length() != 0 &&
                        txtphn.getText().toString().trim().length() != 0) {
                    Intent intent = new Intent(getApplicationContext(), Bill.class);
                    intent.putExtra("bname", getIntent().getStringExtra("name"));
                    intent.putExtra("price", getIntent().getStringExtra("price"));
                    intent.putExtra("quantity", getIntent().getStringExtra("quantity"));
                    intent.putExtra("totalamount", getIntent().getStringExtra("totalamount"));
                    intent.putExtra("pname", txtname.getText().toString());
                    intent.putExtra("add", txtadd.getText().toString());
                    intent.putExtra("email", txtemail.getText().toString());
                    intent.putExtra("phn", txtphn.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}