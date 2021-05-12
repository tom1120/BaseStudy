package designPattern.prototype;

import java.util.ArrayList;

/**
 * Created by zhaoyipc on 2019-05-03.
 */
public class Thing implements Cloneable{
    private ArrayList<String> arrayList=new ArrayList<String>();
    public Thing(){
        System.out.println("构造函数被执行了");
    }
    @Override
    protected Thing clone() {
        Thing thing=null;
        try {
            thing= (Thing) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }

    public void setValue(String value){
        this.arrayList.add(value);
    }
    public ArrayList<String> getValue(){
        return this.arrayList;
    }

}
