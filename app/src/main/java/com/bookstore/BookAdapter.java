package com.bookstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    private Context mContext;
    private int mResource;

    public BookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Book> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtname = convertView.findViewById(R.id.txtname);
        TextView txtdes = convertView.findViewById(R.id.txtdes);
        TextView txtprice = convertView.findViewById(R.id.price);

        imageView.setImageResource(getItem(position).getImage());
        txtname.setText(getItem(position).getName());
        txtdes.setText(getItem(position).getDes());
        txtprice.setText(getItem(position).getPrice());


        return convertView;
    }
}
