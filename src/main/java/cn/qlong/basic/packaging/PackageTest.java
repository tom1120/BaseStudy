package cn.qlong.basic.packaging;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class PackageTest {
    public static void main(String[] args) {
        User user=new User();
        user.setAge(20);
        user.setSex(1);
        user.setName("张三");

        System.out.println("user = " + user);
    }
}

class User{
    private String name;
    private int age;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String str="姓名为"+this.name+"年纪为"+this.age+"性别"+(this.sex==1?"男":"女");
        return str;
    }
}