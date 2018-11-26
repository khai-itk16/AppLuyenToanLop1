package com.itk16.bk.pc.appluyentoanlop1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.itk16.bk.pc.appluyentoanlop1.R;
import com.itk16.bk.pc.appluyentoanlop1.model.ItemImage;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewGame4 extends ArrayAdapter<ItemImage>{
    private Context context;
    private int resource ;
    private ArrayList<ItemImage> arr;
    public CustomGridViewGame4(@NonNull Context context, int resource, @NonNull ArrayList<ItemImage> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resource= resource;
        this.arr= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        ItemImage itemImage= arr.get(position);
        TextView textView=(TextView)convertView.findViewById(R.id.Tv);
        textView.setText(itemImage.getmImageName());
        textView.setBackgroundResource(itemImage.getmImageResource());
        return convertView;
    }
}
