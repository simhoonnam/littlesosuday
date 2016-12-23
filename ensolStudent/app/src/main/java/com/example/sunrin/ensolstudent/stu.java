package com.example.sunrin.ensolstudent;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by Sunrin on 2016-12-23.
 */
public class Stu extends RealmObject{

    @Index
    public  long id;

    private String name;
    private String phone;
    private String image;

    public  Stu(){

    }

    public Stu(String name, String phone, String image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

