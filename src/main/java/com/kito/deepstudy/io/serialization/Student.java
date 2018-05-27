package com.kito.deepstudy.io.serialization;/**
 * Created by hasee on 2017/6/7.
 */

import java.io.Serializable;

/**
 * @author zhaoyi
 * @createTime 2017-06-2017/6/7-20:26
 */
public class Student implements Serializable{

    private Integer id;
    private String name;
    private transient String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
