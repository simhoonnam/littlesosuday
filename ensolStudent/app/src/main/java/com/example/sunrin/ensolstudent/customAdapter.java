package com.example.sunrin.ensolstudent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Sunrin on 2016-12-23.
 */
public class customAdapter extends BaseAdapter {

    private List<Stu> stuList;

    public customAdapter(List<Stu> stuList) {
        this.stuList = stuList;
    }

    @Override
    public int getCount() {
        return stuList.size();
    }

    @Override
    public Object getItem(int position) {
        return stuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,null);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageview);
        TextView textView_name = (TextView)view.findViewById(R.id.name_tv);
        TextView textView_phone = (TextView)view.findViewById(R.id.phone_tv);

        Stu stu = stuList.get(position);
        String name = stu.getName();
        String phone = stu.getPhone();
        String image = stu.getImage();

        textView_name.setText("이름 : "+name);
        textView_phone.setText("전화번호 : "+phone);
        Glide.with(parent.getContext()).load(stu.getImage()).into(imageView);

        return view;
    }
}
