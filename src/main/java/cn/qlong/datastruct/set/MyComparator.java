package cn.qlong.datastruct.set;

import java.util.Comparator;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;
        System.out.println(b1+" comparator "+b2);
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        }
        if (b1.getPrice() < b2.getPrice()) {
            return -1;
        }
        return b1.getName().compareTo(b2.getName());
    }
}
