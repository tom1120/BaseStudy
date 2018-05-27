package liuhe;

/**
 * 三个红蓝绿
 * Created by hasee on 2018/2/8.
 */
public enum BoDuan {
    RED("红", ShengXiaoFinal.reds),BLUE("蓝", ShengXiaoFinal.blues),GREEN("绿", ShengXiaoFinal.greens);

    private String name;
    private Integer[] arrays;

    private BoDuan(String name,Integer[] arrays) {
        this.name=name;
        this.arrays=arrays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getArrays() {
        return arrays;
    }

    public void setArrays(Integer[] arrays) {
        this.arrays = arrays;
    }
}
