package cn.qlong.calculate;

import java.math.BigDecimal;

/**
 * Created by zhaoyipc on 2021-04-17.
 */
public class ExchangeNumber {

    public static void main(String[] args) {
        double d=32.25d;
        String binary=decimal2Binary(d,8);
        System.out.println("binary = " + binary);
    }

    /**
     * 获取浮点数整数部分及小数部分
     * @param d
     * @return
     */
    private static Number[] getIntPartOfDouble(Double d){
        int intpart=Integer.valueOf(String.valueOf(d).substring(0,String.valueOf(d).indexOf(".")));
        double doublepart=Double.valueOf(String.valueOf(d).substring(String.valueOf(d).indexOf(".")));
        Number[] number={intpart,doublepart};
        return number;
    }

    /**
     * 十进制转二进制
     */
    public static String decimal2Binary(int de) {
        String numstr = "";
        while (de > 0) {
            int res = de % 2; // 除2 取余数作为二进制数
            numstr = res + numstr;
            de = de / 2;
        }
        return numstr;

    }

    /**
     * 十进制转为二进制
     * @param d
     * @return
     */
    public static String decimal2Binary(double d,int percision_pos){
        String numstr="";
        // 获取数据的整数部分
        Number[] numbers=getIntPartOfDouble(d);
        int intpart=(Integer) numbers[0];
        double doublepart=(Double) numbers[1];
        String binaryIntPart="";
        if(intpart!=0){
            binaryIntPart=decimal2Binary(intpart);
        }
        String binaryDoublePart="";
        if(doublepart!=0.0){
            while (doublepart<1){
                BigDecimal res=new BigDecimal(doublepart);
                res=res.multiply(new BigDecimal(2));
                doublepart=res.doubleValue();
                if(doublepart>1){
                    binaryDoublePart=binaryDoublePart+1;
                    doublepart=doublepart-1;
                }else if(doublepart==1.0){
                    binaryDoublePart=binaryDoublePart+1;
                    doublepart=1;
                }else{
                    binaryDoublePart=binaryDoublePart+0;
                }

                if(binaryDoublePart.length()>percision_pos){
                    doublepart=1;
                }
            }
        }
        return binaryIntPart+"."+binaryDoublePart;
    }


    /**
     * 将二进制转换为10进制
     * @param bi ：待转换的二进制
     * @return
     */
    public static Integer biannary2Decimal(int bi) {
        String binStr = bi + "";
        Integer sum = 0;
        int len = binStr.length();
        for (int i = 1; i <= len; i++) {
            // 第i位 的数字为：
            int dt = Integer.parseInt(binStr.substring(i - 1, i));
            sum += (int) Math.pow(2, len - i) * dt;
        }
        return sum;
    }



}
