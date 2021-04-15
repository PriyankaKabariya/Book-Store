package com.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    List<SettingsClass> settingsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.setting);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.setting:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
//                    case R.id.myorder:
//                        startActivity(new Intent(getApplicationContext(), MyOrderActivity.class));
//                        overridePendingTransition(0, 0);
//                        finish();
//                        return true;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        initData();
        setRecyclerView();


    }

    private void setRecyclerView() {
        SettingsAdapter settingsAdapter = new SettingsAdapter(settingsList);
        recyclerView.setAdapter(settingsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        settingsList = new ArrayList<>();

        settingsList.add(new SettingsClass("Our Product", "Our parent company, Book Depot, has been offering customers amazing deals on new books since they began selling online in 1997.\n" +
                "Our product is purchased from many different publishers at amazing prices and we pass along these savings by selling them to our customers for deeply discounted prices.\n\n" +
                "Sticker Removal\n\n" +
                "If you do receive a book with a sticker, here are some tips and tricks that we have found useful for removing them:\n\n" +
                "1. Pencil Eraser: Use a pencil eraser to remove any leftover sticky residue.\n\n" +
                "2. Nail Polish Remover: Put some non-acetone nail polish remover on a cotton ball. Blot it onto the residue, and then wipe the residue off.\n\n" +
                "3. Goo Gone: Apply Goo Gone directly to the sticker and then wipe residue off."));

        settingsList.add(new SettingsClass("Our Purpose", "Enchanting the Mind, One Book at a Time\n\n" +
                "At Book Outlet, our core focus is Enchanting the Mind. " +
                "\nThis is our why, our purpose, our passion behind everything we do. " +
                "\nWe believe we are not just selling books, rather we are impacting the lives of millions of people both locally and across the globe.\n\n" +
                "As readers, we know the joy that reading brings but we also know how expensive new books can be. \n" +
                "That is why we strive to offer read-iculously low prices on great titles, so that the joy of reading can be accessible to all."));

        settingsList.add(new SettingsClass("Our History", "The roots of Book Stores go back to the year 1985 and the entrepreneurial vision of John Hultink, our company’s founder.\n\n" +
                "John is one of five brothers who, together with his parents, immigrated to Canada from the Netherlands shortly after World War II, seeking a better life across the Atlantic. Like many immigrant families, those early years were not easy but that struggle had a pivotal influence on the roots of our company.\n" +
                "\n" +
                "John’s passion for books and his entrepreneurial drive began well before 1985, going back to the early 1970s when he founded a small publishing company that translated Dutch books into English. These books appealed to many immigrant families across Canada who wanted their children to have the same experiences they had grown to know and love as children.\n" +
                "\n" +
                "After witnessing the impact that books had in the lives of immigrant families, John was determined to make books accessible to all families across the globe by offering them at affordable prices - and that was the beginning of Book Stores!"));

        settingsList.add(new SettingsClass("Privacy & Security", "Privacy Policy\n\n" +
                "This Privacy Policy describes how your personal information is collected, used, and shared when you visit or make a purchase from www.bookstores.ca (the “Site”).\n\n" +
                "PERSONAL INFORMATION WE COLLECT\n" +
                "When you visit the Site, we automatically collect certain information about your device, including information about your web browser, IP address, time zone, and some of the cookies that are installed on your device. Additionally, as you browse the Site, we collect information about the individual web pages or products that you view, what websites or search terms referred you to the Site, and information about how you interact with the Site. We refer to this automatically-collected information as “Device Information.”\n" +
                "\n" +
                "We collect Device Information using the following technologies:\n" +
                "\n" +
                "“Cookies” are data files that are placed on your device or computer and often include an anonymous unique identifier. For more information about cookies, and how to disable cookies, visit http://www.allaboutcookies.org.\n" +
                "“Log files” track actions occurring on the Site, and collect data including your IP address, browser type, Internet service provider, referring/exit pages, and date/time stamps.\n" +
                "“Web beacons,” “tags,” and “pixels” are electronic files used to record information about how you browse the Site.\n" +
                "Additionally, when you make a purchase or attempt to make a purchase through the Site, we collect certain information from you, including your name, billing address, shipping address, payment information (including credit card numbers, Visa Debit card numbers, PayPal ID), email address, and phone number. We refer to this information as “Order Information.”\n" +
                "\n" +
                "If you choose to log in to the Site using a social media account, you give us the permission to collect your email address.\n" +
                "\n" +
                "When we talk about “Personal Information” in this Privacy Policy, we are talking both about Device Information and Order Information."));

        settingsList.add(new SettingsClass("Our Values", "At Book Stores, we believe that reading is at the heart of Enchanting the Mind, and it is our shared responsibility to bring this purpose to life – one book at a time! Our culture and everything that we do is guided by our six Core Values.\n\n" +
                "1. We Not Me : \n" +
                "We understand that success is fleeting if we don’t put others first. Serving with humility and always looking to the interests of our team members and customers is foundational to all we do.\n\n" +
                "2. Ride Together. Win Together. : \n" +
                "We believe that the whole TEAM is greater than the sum of its individual players and that Together Everyone Achieves More.\n\n" +
                "3. Wake Up. Be Awesome. Repeat. :\n" +
                "We believe that working hard is actually the result of a great attitude and passion for living each day at our best.\n\n" +
                "4. Kick Some Moon Dust\n" +
                "We believe that to really be great, you have to be willing to go where no one has ever gone before. To do this requires an ownership thinking mentality, hard work, determination, and a can-do attitude.\n\n" +
                "5. We Eat The Stinky Cheese\n" +
                "We have a curious mind, and we never stop learning. In fact, our desire to learn and grow is so strong that we will even try new things that don’t look so appealing at first glance.\n\n" +
                "6. No Donkeys\n" +
                "We know life is too short to work with, or do business with, those that think and act like donkeys."));


        settingsList.add(new SettingsClass("Our Location", "ST. CATHARINES STORE\n\n" +
                "Hours Of Operation\n" +
                "Tuesday to Saturday\n" +
                "11am to 6pm\n\n" +
                "Contact\n" +
                "905.641.4581\n\n\n" +
                "CANADIAN WAREHOUSE\n\n" +
                "Mailing Address\n" +
                "67 Front Street North\n" +
                "Thorold, Ontario\n" +
                "L2V 1X3, Canada\n\n" +
                "Hours Of Operation\n" +
                "Closed to the public\n" +
                "Wholesalers by appointment only\n\n" +
                "Contact\n" +
                "1-888-402-7323\n\n" +
                "Monday - Friday 8:30am to 5:00pm EST"));

        settingsList.add(new SettingsClass("Returns Process", "All of our books have a We're Readers Too 110% Guarantee. If you are not satisfied with your purchase, place a Service Inquiry with our customer service team within 5 days of receiving your order. Be sure to select the \"Returns, Refunds or Replacements\" subject line option. Please include your order number and contact information as well as the reason for your return.\n" +
                "\n" +
                "Our customer service team will respond with a Return Authorization Number (RAN) and once we have received your return back at our facility you will be reimbursed. Please note, the original shipping charge and the cost associated with sending the item back to us will not be available for refund. We do not accept returns without a Return Authorization Number.\n" +
                "\n" +
                "Important: Book Outlet cannot refund/credit/replace an order after 45 days from the original purchase date.\n" +
                "\n" +
                "If your order arrives and you notice a shortage, damages or an error, you must report it within a maximum of 5 days from when the order was expected to be delivered. Be sure to select the Order Issue subject line option. Please include your order number, contact information, as well as a brief description of the issue. Should you be reporting damages, please include pictures of the damages along with the title(s) affected - we will be happy to assist you further.\n" +
                "\n" +
                "Any sealed products (music CDs, audio books, videos, software, etc.) cannot be returned once they have been opened.\n" +
                "\n" +
                "If Returns should become excessive or unwarranted then Book Stores has the right to restrict or disallow returns at our discretion.\n" +
                "\n"));

        settingsList.add(new SettingsClass("Our Impact", "We understand the importance of serving with humility and putting the needs of others first, which is why it has always been a part of our culture to give back to the community."));

        settingsList.add(new SettingsClass("Your Rights", "If you are a European resident, you have the right to access personal information we hold about you and to ask that your personal information be corrected, updated, or deleted. If you would like to exercise this right, please contact us through the contact information below.\n" +
                "\n" +
                "Additionally, if you are a European resident we note that we are processing your information in order to fulfill contracts we might have with you (for example if you make an order through the Site), or otherwise to pursue our legitimate business interests listed above. Additionally, please note that your information will be transferred outside of Europe, including to Canada and the United States."));

        settingsList.add(new SettingsClass("Contact Us", "For more information about our privacy practices, if you have questions, or if you would like to make a complaint, please create an online ticket or by mail using the details provided below:\n" +
                "\n" +
                "67 Front Street North, Thorold, ON, L2V1X3, Canada"));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}