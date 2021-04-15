package com.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView txtregister;
    TextView txtforgotpass;
    Button btnlogin;
    ImageView imgshare;
    EditText txtemail, txtpassword;
    CheckBox chkme;
    public static String PREFS_NAME = "mypre";
    public static String PREF_USERNAME = "username";
    public static String PREF_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtregister = findViewById(R.id.txtregister);
        txtforgotpass = findViewById(R.id.txtforgotpass);
        btnlogin = findViewById(R.id.btnlogin);
        imgshare = findViewById(R.id.imgshare);
        txtemail = findViewById(R.id.txtemail);
        txtpassword = findViewById(R.id.txtpassword);
        chkme = findViewById(R.id.chkme);

        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });

        txtforgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((txtemail.getText().toString().equals(getIntent().getStringExtra("email"))) &&
                        (txtpassword.getText().toString().equals(getIntent().getStringExtra("password")))) {
                    String username = txtemail.getText().toString();
                    String password = txtpassword.getText().toString();

                    if (chkme.isChecked())
                        rememberMe(username, password); //save username and password
                    //show logout activity
                    showLogout(username);

                }
                else {
                    txtemail.setError("Please enter valid email");
                    txtpassword.setError("Please enter valid password");
                }
            }

        });

        imgshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
            }
        });
    }

    public void getUser() {
        SharedPreferences pref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String username = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);

        if (username != null || password != null) {
            //directly show logout form
            showLogout(username);
        }
    }

    public void rememberMe(String user, String password) {
        //save username and password in SharedPreferences
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME, user)
                .putString(PREF_PASSWORD, password)
                .commit();
    }

    public void showLogout(String username) {
        //display log out activity
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("user", username);
        startActivity(intent);
    }

    public void onStart() {
        super.onStart();
        //read username and password from SharedPreferences
        getUser();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        android.os.Process.killProcess(android.os.Process.myPid());
        // finish();
    }

}