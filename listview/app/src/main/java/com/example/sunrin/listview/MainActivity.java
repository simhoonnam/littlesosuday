package com.example.sunrin.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    private List<stu> stuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stuList.add(new stu(13,"홍길동"));
        stuList.add(new stu(14,"홍길동"));
        stuList.add(new stu(15,"홍길동"));
        stuList.add(new stu(16,"홍길동"));
        stuList.add(new stu(17,"홍길동"));
        stuList.add(new stu(18,"홍길동"));
        stuList.add(new stu(19,"홍길동"));
        stuList.add(new stu(20,"홍길동"));
        stuList.add(new stu(21,"홍길동"));


        listview=(ListView)findViewById(R.id.listV);
        customAdapter adapter = new customAdapter(stuList);


        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           //     Toast.makeText(getApplicationContext(),ITEMS[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
