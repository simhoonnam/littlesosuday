package com.example.sunrin.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText_type;
    EditText editText_name;
    EditText editText_age;
    Button button;

    private ListView listView;
    private  customAdapter customAdapter;
    private List<Pet> petList = new ArrayList<>();

    private String type;
    private String name;
    private int age;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //초기화
        Realm.init(getApplicationContext());

        realm = Realm.getDefaultInstance();

        listData();

        setDefault();
    }

    private void listData() {
        petList.add(new Pet("인간","강은솔",17));
        petList.add(new Pet("인간","오민재",17));
        petList.add(new Pet("인간","박태준",17));
        petList.add(new Pet("인간","돌도원",17));
    }

    private void setDefault() {
        //선언
        editText_type=(EditText)findViewById(R.id.editType);
        editText_name=(EditText)findViewById(R.id.editName);
        editText_age=(EditText)findViewById(R.id.editAge);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        //리스트뷰
        listView=(ListView)findViewById(R.id.ensolData);
        customAdapter adapter = new customAdapter(getPets());

        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                petAppend();
                break;
        }
    }

    //데이터추가
    private void petAppend() {
        type = editText_type.getText().toString();
        name = editText_name.getText().toString();
        age = Integer.parseInt(editText_age.getText().toString());

        realmHere();

    }

    private void realmHere() {
        //DB 시작
        realm.beginTransaction();
        Pet pet = realm.createObject(Pet.class);
        pet.setAge(age);
        pet.setName(name);
        pet.setType(type);

        //DB 끝
        realm.commitTransaction();

        petList.add(pet);

        customAdapter = new customAdapter(getPets());
        listView.setAdapter(customAdapter);
    }

    private List<Pet> getPets(){
        //HWERE
        RealmResults<Pet> all = realm.where(Pet.class).findAll();
        petList = new ArrayList<>();
        for(int i=0; i< all.size();i++){
            petList.add(all.get(i));
        }
        return petList;
    }
}
