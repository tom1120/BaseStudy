package liuhe;/**
 * Created by hasee on 2018/2/7.
 */

import java.util.List;

/**
 * 生肖实体类
 * @author zhaoyi
 * @createTime 2018-02-2018/2/7-20:28
 */
public class ShengXiaoShou extends ShengXiao {
    private Long year;

    /**
     * 初始化方法
     */
    private void init(){
        this.currentNum=1;
        List<Integer> nums=shengXiaoHaoMa.getNums();
        for (int i = 0; i < 5; i++) {
            nums.add(this.currentNum+i*12);
        }
        String[] shengxiaos=ShengXiaoFinal.shengxiaos;
        for (int i = 0; i <=shengxiaos.length; i++) {
            if(shengxiaos[i].equals(this.name)){
                this.currentPaiwei=i+1;
                break;
            }
        }

    }

    public ShengXiaoShou(Long year, String name) {
        this.year = year;
        this.name=name;
        init();
    }

    public ShengXiaoShou() {
        this(2017L,"鸡");
    }



    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }


}
