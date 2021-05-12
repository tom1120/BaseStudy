package cn.qlong.basic.clone;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class Student2 implements Cloneable {
    private int number;
    private Address addr;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    protected Object clone() {
        Student2 stu2=null;
        try {
            stu2= (Student2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return stu2;
    }
}
