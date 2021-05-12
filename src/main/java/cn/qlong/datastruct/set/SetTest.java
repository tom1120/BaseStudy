package cn.qlong.datastruct.set;

import java.util.*;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class SetTest {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        Set treeSet = new TreeSet();
        Set linkedSet = new LinkedHashSet();


        set();
        hashSetTest();
        treeSet1();
        treeSet2();
    }

    /**
     * set去重
     */
    public static void set(){
        // 初始化list
        List<String> list = new ArrayList<String>();
        list.add("Jhon");
        list.add("Jency");
        list.add("Mike");
        list.add("Dmitri");
        list.add("Mike");
        // 利用set不允许元素重复的性质去掉相同的元素
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < list.size(); i++) {
            String items = list.get(i);
            System.out.println("items:"+items);
            if (!set.add(items)) {
                // 打印重复的元素
                System.out.println("重复的数据: " + items);
            }
        }
        System.out.println("list:"+list);
    }

    /**
     *  使用hashSet去重
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void hashSetTest(){
        HashSet hs = new HashSet();
        //	TreeMap tm=new TreeMap();
        hs.add(new AA("ABC", 20));
        hs.add(new AA("BCD", 20));
        hs.add(new AA("CDE", 20));
        hs.add(new AA("ABC", 20));
        hs.add(new AA("BCD", 20));
        Iterator it = hs.iterator();   //定义迭代器
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println("排序之前:"+next);
//            Entry<String, Object> me=(Entry<String, Object>) it.next();
//            tm.put(me.getKey(), me.getValue());
        }
//        System.out.println("TreeMap排序之后:"+tm);
    }

    /**
     * 一，让容器自身具备比较性，自定义比较器。
     需求：当元素自身不具备比较性，或者元素自身具备的比较性不是所需的。
     那么这时只能让容器自身具备。
     定义一个类实现Comparator 接口，覆盖compare方法。
     并将该接口的子类对象作为参数传递给TreeSet集合的构造函数。
     当Comparable比较方式，及Comparator比较方式同时存在，以Comparator
     比较方式为主
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void treeSet1(){
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add(new Book("think in java", 100));
        ts.add(new Book("java 核心技术", 75));
        ts.add(new Book("现代操作系统", 50));
        ts.add(new Book("java就业教程", 35));
        ts.add(new Book("think in java", 100));
        ts.add(new Book("ccc in java", 100));

        System.out.println("treeSet1:"+ts);
    }

    /**
     *
     二，让元素自身具备比较性。
     也就是元素需要实现Comparable接口，覆盖compareTo 方法。
     这种方式也作为元素的自然排序，也可称为默认排序。
     年龄按照搜要条件，年龄相同再比姓名。
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void treeSet2(){
        TreeSet ts = new TreeSet();
        ts.add(new Person("aa", 20, "男"));
        ts.add(new Person("bb", 18, "女"));
        ts.add(new Person("cc", 17, "男"));
        ts.add(new Person("dd", 17, "女"));
        ts.add(new Person("dd", 15, "女"));
        ts.add(new Person("dd", 15, "女"));

        System.out.println("treeSet2:"+ts);
        System.out.println(ts.size()); // 5
    }
}
