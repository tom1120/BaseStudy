package cn.qlong.basic.extend;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class Son extends Father {
    public Son(String name ,Integer age){
        this.name=name;
        this.age=age;
    }
    public Son(){
        this("张ss",11);
//        super();

    }

}
