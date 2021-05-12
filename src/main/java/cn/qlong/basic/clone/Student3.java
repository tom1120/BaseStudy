package cn.qlong.basic.clone;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class Student3 implements Cloneable {
    private int number;
    private Address3 addr3;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address3 getAddr3() {
        return addr3;
    }

    public void setAddr3(Address3 addr3) {
        this.addr3 = addr3;
    }

    @Override
    protected Object clone(){
        Student3 student3=null;
        try {
            student3= (Student3) super.clone();// 浅复制
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        student3.addr3= (Address3) addr3.clone(); //深度复制
        return student3;
    }
}
