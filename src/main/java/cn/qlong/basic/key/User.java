package cn.qlong.basic.key;

/**
 * Created by zhaoyipc on 2021-04-21.
 */
public class User {
    // synchronized 可以保证可见性和原子性，volatile只保证了可见性
    private volatile int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
