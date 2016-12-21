package com.example.sunrin.listview;

/**
 * Created by Sunrin on 2016-12-21.
 */
public class stu {
    private String name;
    private long id;

    public stu(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
