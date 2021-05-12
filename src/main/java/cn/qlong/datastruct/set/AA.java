package cn.qlong.datastruct.set;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class AA {
    private String name;
    private int age;

    public AA(String name, int age) {
        this.name=name;
        this.age=age;
    }

    AA() {

    }
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

    //重写hashCode
    @Override
    public int hashCode() {
        System.out.println("hashCode:" + this.name);
        return this.name.hashCode() + age * 37;
    }

    //重写equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AA) {
            AA a = (AA) obj;
            return this.name.equals(a.name) && this.age == a.age;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + " 年龄:" + this.age;
    }
}
