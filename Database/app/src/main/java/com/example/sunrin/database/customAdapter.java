package com.example.sunrin.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Sunrin on 2016-12-23.
 */
public class customAdapter extends BaseAdapter {

    private List<Pet> petList;

    public customAdapter(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public int getCount() {
        return petList.size();
    }

    @Override
    public Object getItem(int position) {
        return petList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet,null);

        TextView textView_type = (TextView)view.findViewById(R.id.text_type);
        TextView textView_name = (TextView)view.findViewById(R.id.text_name);
        TextView textView_age = (TextView)view.findViewById(R.id.text_age);

        Pet pet = petList.get(position);
        String type = pet.getType();
        String name = pet.getName();
        String age = String.valueOf(pet.getAge());

        textView_type.setText("종류 : "+type);
        textView_name.setText("이름 : "+name);
        textView_age.setText("나이 : "+age);

        return view;
    }
}
