package com.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ListView listView;
    SharedPreferences sp;
    String user;
    public static String PREFS_NAME = "mypre";
    public static String PREF_USERNAME = "username";
    public static String PREF_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
//                    case R.id.myorder:
//                        startActivity(new Intent(getApplicationContext(), MyOrderActivity.class));
//                        overridePendingTransition(0, 0);
//                        finish();
//                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                }
                return false;
            }
        });


        listView = findViewById(R.id.listView);
        ArrayList<Book> arrayList = new ArrayList<>();

        arrayList.add(new Book(R.drawable.apromisedland, "A Promised Land", "Price : $", "20"));
        arrayList.add(new Book(R.drawable.bagman, "BagMan", "Price : $", "17"));
        arrayList.add(new Book(R.drawable.becoming, "Becoming", "Price : $", "15"));
        arrayList.add(new Book(R.drawable.humans, "Humans", "Price : $", "24"));
        arrayList.add(new Book(R.drawable.moderncomfortfood, "Modern Comfort Food", "Price : $", "19"));
        arrayList.add(new Book(R.drawable.readyplayertwo, "Ready Player Two", "Price : $", "13"));
        arrayList.add(new Book(R.drawable.modernwarriors, "Modern Warriors", "Price : $", "14"));
        arrayList.add(new Book(R.drawable.myownwords, "My Own Words", "Price : $", "21"));
        arrayList.add(new Book(R.drawable.wherethecrawdadssing, "Where The Crawdads Sing", "Price : $", "4"));
        arrayList.add(new Book(R.drawable.atomichabits, "Atomic Habits", "Price : $", "12"));


        BookAdapter personAdapter = new BookAdapter(this, R.layout.list_row, arrayList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imgg = view.findViewById(R.id.image);
                imgg.setDrawingCacheEnabled(true);
                Bitmap b = imgg.getDrawingCache();

                TextView tname = view.findViewById(R.id.txtname);
                TextView tdes = view.findViewById(R.id.txtdes);
                TextView tprice = view.findViewById(R.id.price);

                AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                builder.setTitle("Enter Book Quantity : ");

                final EditText input = new EditText(Home.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setCancelable(false);
                builder.setView(input);


                builder.setNegativeButton("Cancel", null);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getApplicationContext(), input.getText().toString(), Toast.LENGTH_SHORT).show();
                        if (input.getText().toString().trim().length() == 0) {
                            input.setError("Please enter quantity");
                        } else {
                            Intent intent = new Intent(getApplicationContext(), MyOrderActivity.class);
                            intent.putExtra("img", b);
                            intent.putExtra("name", tname.getText().toString());
                            intent.putExtra("price", tprice.getText().toString());
                            intent.putExtra("quantity", input.getText().toString());
                            startActivity(intent);
                        }
                    }
                });

                builder.show();

                try {
                    Intent intent = getIntent();
                    Bundle bn = intent.getExtras();
                    user = bn.getString("user");

                    SharedPreferences pref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                    String username = pref.getString(PREF_USERNAME, null);
                    String password = pref.getString(PREF_PASSWORD, null);
                }catch (Exception e){

                }

            }
        });

        listView.setAdapter(personAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage = "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
                return true;
            case R.id.logout:
                SharedPreferences sharedPrefs = getSharedPreferences(Login.PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.clear();
                editor.commit();
                user = "";
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        android.os.Process.killProcess(android.os.Process.myPid());
        // finish();
    }


}