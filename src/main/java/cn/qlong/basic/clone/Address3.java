package cn.qlong.basic.clone;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class Address3 implements Cloneable{
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    protected Object clone(){
        Address3 addr3=null;
        try {
            addr3= (Address3) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addr3;
    }
}
