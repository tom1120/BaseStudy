package algorithm.sort;

/**
 * Created by zhaoyipc on 2021-04-21.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("oneToHun(100,1) = " + oneToHun(100, 1));
    }

    public static int oneToHun(int n,int step){
        if(n==1)
            return 1;
        return n+oneToHun(n-1,step);

    }

}
