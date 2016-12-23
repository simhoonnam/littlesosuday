package com.example.sunrin.ensolstudent;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText_name,editText_phone,editText_image;
    Button button;

    private ListView listView;
    private customAdapter customAdapter;
    private List<Stu> stuList =new ArrayList<>();

    private String name;
    private String phone;
    private String image;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //초기화
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        setDefault();
    }

    private void setDefault() {

        editText_name=(EditText)findViewById(R.id.editName);
        editText_phone=(EditText)findViewById(R.id.editPhone);
        editText_image=(EditText)findViewById(R.id.editImage);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        //리스트뷰
        listView=(ListView)findViewById(R.id.studentdata);
        customAdapter adapter = new customAdapter(getStu());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RealmResults<Stu> all = realm.where(Stu.class).findAll();
                Stu stu = all.get(position);

                realm.beginTransaction();
                stu.deleteFromRealm();
                realm.commitTransaction();

                customAdapter = new customAdapter(getStu());
                listView.setAdapter(customAdapter);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                petAppend();
                break;
        }
    }

    private void petAppend() {
        name =editText_name.getText().toString();
        phone=editText_phone.getText().toString();
        image=editText_image.getText().toString();

        realmHere();
    }

    private void realmHere() {

        realm.beginTransaction();
        Stu stu =realm.createObject(Stu.class);
        stu.setName(name);
        stu.setPhone(phone);

        //DB 끝
        realm.commitTransaction();

        stuList.add(stu);

        customAdapter = new customAdapter(getStu());
        listView.setAdapter(customAdapter);


    }

    private List<Stu> getStu(){

        RealmResults<Stu> all = realm.where(Stu.class).findAll();
        stuList = new ArrayList<>();
        for(int i=0; i< all.size();i++){
            stuList.add(all.get(i));
        }
        return stuList;
    }
}
