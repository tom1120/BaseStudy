package com.kito.deepstudy.map;/**
 * Created by hasee on 2016/10/24.
 */

/**
 * @author zhaoyi
 * @createTime 2016-10-2016/10/24-21:20
 */
public class Student {
    private Integer classno;
    private String studentname;
    private Integer score;

    public Student() {
    }

    public Student(Integer classno, String studentname, Integer score) {
        this.classno = classno;
        this.studentname = studentname;
        this.score = score;
    }

    public Integer getClassno() {
        return classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
