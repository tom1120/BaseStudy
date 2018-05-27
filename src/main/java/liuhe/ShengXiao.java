package liuhe;/**
 * Created by hasee on 2018/2/9.
 */

/**
 * @author zhaoyi
 * @createTime 2018-02-2018/2/9-15:08
 */
public class ShengXiao {
    protected Integer currentPaiwei;
    protected Integer currentNum;
    protected String name;
    protected ShengXiaoHaoMa shengXiaoHaoMa=new ShengXiaoHaoMa();

    public Integer getCurrentPaiwei() {
        return currentPaiwei;
    }

    public void setCurrentPaiwei(Integer currentPaiwei) {
        this.currentPaiwei = currentPaiwei;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShengXiaoHaoMa getShengXiaoHaoMa() {
        return shengXiaoHaoMa;
    }

    public void setShengXiaoHaoMa(ShengXiaoHaoMa shengXiaoHaoMa) {
        this.shengXiaoHaoMa = shengXiaoHaoMa;
    }



}
