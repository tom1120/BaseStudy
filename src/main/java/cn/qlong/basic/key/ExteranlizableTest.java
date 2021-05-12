package cn.qlong.basic.key;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by zhaoyipc on 2021-04-21.
 */
public class ExteranlizableTest implements Externalizable{

    private transient int s;
    private String name;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(s);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        s= (int) in.readObject();
    }


    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExteranlizableTest{" +
                "s=" + s +
                ", name='" + name + '\'' +
                '}';
    }
}
