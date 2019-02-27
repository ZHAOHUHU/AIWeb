package shenzhen.teamway.jsonResult;

import java.io.Serializable;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-27 16:12
 **/
public class Region implements Serializable{

    private static final long serialVersionUID = -6888527616759294240L;
    private int r1;
    private int r2;
    private int c1;
    private int c2;

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    @Override
    public String toString() {
        return "Region{" +
                "r1=" + r1 +
                ", r2=" + r2 +
                ", c1=" + c1 +
                ", c2=" + c2 +
                '}';
    }
}