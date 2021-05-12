package cn.qlong.basic.key;

import java.io.Serializable;

/**
 *
 * serialVersionUID
 如果你的类Serialized存到硬盘上面后，可是后来你却更改了类别的field(增加或减少或改名)，当你Deserialize时，就会出现Exception的，这样就会造成不兼容性的问题。
 但当serialVersionUID相同时，它就会将不一样的field以type的预设值Deserialize，可避开不兼容性问题。
 * Created by zhaoyipc on 2021-04-21.
 */
public class SerializableTest implements Serializable{
    private static final long serialVersionUID=-1;
    // 不会序列化 Exteranlizable Serializable
    private transient int s;
//    private  int s;
    private String name;
    // static静态变量不能序列化

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
        return "SerializableTest{" +
                "s=" + s +
                ", name='" + name + '\'' +
                '}';
    }
}
