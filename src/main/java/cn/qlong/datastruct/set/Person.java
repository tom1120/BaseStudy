package cn.qlong.datastruct.set;

import java.util.Comparator;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class Person implements Comparable {

    private String name;
    private int age;
    private String gender;   //性别

    public Person() {
    }
    public Person(String name, int age, String gender) {

        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 37;
    }

    public boolean equals(Object obj) {
        System.err.println(this + "equals :" + obj);
        if (!(obj instanceof Person)) {
            return false;
        }
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;

    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender
                + "]";
    }


    @Override
    public int compareTo(Object obj) {
        Person p = (Person) obj;
        System.out.println(this+" compareTo:"+p);
        if (this.age > p.age) {
            return 1;
        }
        if (this.age < p.age) {
            return -1;
        }
        return this.name.compareTo(p.name);
    }
}
