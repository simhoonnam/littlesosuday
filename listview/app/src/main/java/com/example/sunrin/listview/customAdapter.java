package com.example.sunrin.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sunrin on 2016-12-21.
 */
public class customAdapter extends BaseAdapter {

    private List<stu> stulist;

    public customAdapter(List<stu> stulist) {
        this.stulist = stulist;
    }

    @Override
    public int getCount() {
        //리스트뷰에 뿌려질 데이터의 개수
        return stulist.size();
    }

    @Override
    public Object getItem(int position) {
        return stulist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView textView1 = (TextView)view.findViewById(R.id.textId);
        TextView textView2 = (TextView)view.findViewById(R.id.textName);

        stu stu=stulist.get(position);
        String id = String.valueOf(stu.getId());
        String name = stu.getName();

        textView1.setText(id);
        textView2.setText(name);

        return view;
    }

}
