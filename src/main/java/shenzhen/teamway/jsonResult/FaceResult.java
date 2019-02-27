package shenzhen.teamway.jsonResult;

import java.io.Serializable;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-27 16:12
 **/
public class FaceResult  implements Serializable{

    private static final long serialVersionUID = 3957766118336893046L;
    private double score;
    private Region region;
    //姓名
    private String type;


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FaceResult{" +
                "score=" + score +
                ", region=" + region +
                ", type='" + type + '\'' +
                '}';
    }
}