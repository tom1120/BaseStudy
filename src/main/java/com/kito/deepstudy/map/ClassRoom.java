package com.kito.deepstudy.map;/**
 * Created by hasee on 2016/10/26.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyi
 * @createTime 2016-10-2016/10/26-20:03
 */
public class ClassRoom {
    private Integer classno;
    private List<Student> student;
    private Integer totalscore;

    public ClassRoom() {
        student=new ArrayList<Student>();
    }

    public ClassRoom(Integer classno) {
        this.classno = classno;
        student=new ArrayList<Student>();
    }

    public ClassRoom(Integer classno, List<Student> student, Integer totalscore) {
        this();
        this.classno = classno;
        this.student = student;
        this.totalscore = totalscore;
    }

    public Integer getClassno() {
        return classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }
}
