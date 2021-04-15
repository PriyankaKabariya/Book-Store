package com.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyOrderActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView txtname, txtdes, txtquantity, txttotal, txtt;
    Button btncancel, btncontinue;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

//        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//
//        bottomNavigationView.setSelectedItemId(R.id.myorder);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.myorder:
//                        return true;
//                    case R.id.home:
//                        startActivity(new Intent(getApplicationContext(), Home.class));
//                        overridePendingTransition(0, 0);
//                        finish();
//                        return true;
//                    case R.id.setting:
//                        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
//                        overridePendingTransition(0, 0);
//                        finish();
//                        return true;
//                }
//                return false;
//            }
//        });

        if (getIntent().getStringExtra("name") != null) {

            txtname = (TextView) findViewById(R.id.txtname);
            txtdes = (TextView) findViewById(R.id.txtdes);
            txtquantity = (TextView) findViewById(R.id.txtquantity);
            txttotal = (TextView) findViewById(R.id.txttotal);
            img = (ImageView) findViewById(R.id.img);
            btncancel = findViewById(R.id.btncancel);
            btncontinue = findViewById(R.id.btncontinue);

            Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("img");
            img.setImageBitmap(bitmap);
            txtname.setText("Name : " + getIntent().getStringExtra("name"));
            txtdes.setText("Price : $" + getIntent().getStringExtra("price"));
            txtquantity.setText("Quantity : " + getIntent().getStringExtra("quantity"));
            int price = Integer.parseInt(getIntent().getStringExtra("price"));
            int quan = Integer.parseInt(getIntent().getStringExtra("quantity"));
            txttotal.setText("Total Amount : $" + (price * quan));
            btncontinue.setVisibility(View.VISIBLE);
            btncancel.setVisibility(View.VISIBLE);

            btncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Home.class));
                }
            });

            btncontinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), FillDetail.class);
                    intent.putExtra("name", getIntent().getStringExtra("name"));
                    intent.putExtra("price", getIntent().getStringExtra("price"));
                    intent.putExtra("quantity", getIntent().getStringExtra("quantity"));
                    String s = String.valueOf((price * quan));
                    intent.putExtra("totalamount", s);
                    startActivity(intent);
                }
            });
        } else {
            txtt = findViewById(R.id.txt1);
            txtt.setVisibility(View.VISIBLE);
        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}