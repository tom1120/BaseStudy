package cn.qlong.memoryout;

/**
 * Created by zhaoyipc on 2021-04-23.
 */
public class Perpons {
    private String name ;

    public Perpons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perpons perpons = (Perpons) o;

        return getName().equals(perpons.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
