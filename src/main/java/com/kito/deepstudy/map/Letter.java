package com.kito.deepstudy.map;/**
 * Created by hasee on 2016/10/24.
 */

/**
 * javabean类
 * @author zhaoyi
 * @createTime 2016-10-2016/10/24-21:02
 */
public class Letter {
    private String lettername;
    private Integer letternum;

    public Letter() {
    }

    public Letter(String lettername, Integer letternum) {
        this.lettername = lettername;
        this.letternum = letternum;
    }

    public String getLettername() {
        return lettername;
    }

    public void setLettername(String lettername) {
        this.lettername = lettername;
    }

    public Integer getLetternum() {
        return letternum;
    }

    public void setLetternum(Integer letternum) {
        this.letternum = letternum;
    }
}
