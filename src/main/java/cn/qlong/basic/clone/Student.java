package cn.qlong.basic.clone;

/**
 * 浅克隆1
 * Created by zhaoyipc on 2021-04-16.
 */
public class Student implements Cloneable{
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected Object clone() {
        Student stu=null;
        try {
            stu= (Student) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return stu;
    }


}
