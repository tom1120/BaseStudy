package cn.qlong.basic.extend;

import java.math.BigDecimal;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class Father {
    public String name;
    private BigDecimal money;
    protected int age;
    boolean isHelp;

    /**
     * 存钱
     * @param moneyAdd
     */
    private void storeMoney(BigDecimal moneyAdd){
        this.money=this.money.add(moneyAdd);
    }

    /**
     * 减钱
     * @param moneyTake
     */
    private void takeMoney(BigDecimal moneyTake){
        this.money=this.money.subtract(moneyTake);
    }






}
