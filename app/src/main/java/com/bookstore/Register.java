package com.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText txtname, txtadd, txtemail, txtphn, txtpassword, txtconfirmpassword;
    Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister = findViewById(R.id.btnregister);
        txtname = findViewById(R.id.txtname);
        txtadd = findViewById(R.id.txtadd);
        txtemail = findViewById(R.id.txtemail);
        txtphn = findViewById(R.id.txtphn);
        txtpassword = findViewById(R.id.txtpassword);
        txtconfirmpassword = findViewById(R.id.txtconfirmpassword);

        btnregister.setOnClickListener(new View.OnClickListener() {
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
                if (txtpassword.getText().toString().trim().length() == 0) {
                    txtpassword.setError("Please enter password");
                }
                if (txtconfirmpassword.getText().toString().trim().length() == 0) {
                    txtconfirmpassword.setError("Please enter confirm password");
                }
                if (!txtpassword.getText().toString().equals(txtconfirmpassword.getText().toString())) {
                    txtconfirmpassword.setError("Confirm password is not correct");
                }
                if (txtname.getText().toString().trim().length() != 0 &&
                        txtadd.getText().toString().trim().length() != 0 &&
                        txtemail.getText().toString().trim().length() != 0 &&
                        txtphn.getText().toString().trim().length() != 0 &&
                        txtpassword.getText().toString().trim().length() != 0 &&
                        txtconfirmpassword.getText().toString().trim().length() != 0 &&
                        (txtpassword.getText().toString().equals(txtconfirmpassword.getText().toString()))) {
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    i.putExtra("email", txtemail.getText().toString());
                    i.putExtra("password", txtpassword.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}