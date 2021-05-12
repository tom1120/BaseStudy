package designPattern.prototype;

/**
 * Created by zhaoyipc on 2019-05-03.
 */
public class ThingClient {

    public static void testCloneAndNewDiff(){
        Thing thing=new Thing();
        Thing cloneThing=thing.clone();
    }

    public static void testShallowClone(){
        Thing thing=new Thing();
        thing.setValue("张三" );
        Thing cloneThing=thing.clone();
        cloneThing.setValue("李四");
        System.out.println(thing.getValue());
    }

    public static void main(String[] args) {
        testShallowClone();
    }



}
