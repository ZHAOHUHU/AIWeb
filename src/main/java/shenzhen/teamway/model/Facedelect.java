package shenzhen.teamway.model;

import java.io.Serializable;
import java.util.Date;

public class Facedelect implements Serializable {
    private Integer id;

    private String filepath;

    private String result;

    private String up;

    private Date facetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up == null ? null : up.trim();
    }

    public Date getFacetime() {
        return facetime;
    }

    public void setFacetime(Date facetime) {
        this.facetime = facetime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Facedelect other = (Facedelect) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFilepath() == null ? other.getFilepath() == null : this.getFilepath().equals(other.getFilepath()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getUp() == null ? other.getUp() == null : this.getUp().equals(other.getUp()))
            && (this.getFacetime() == null ? other.getFacetime() == null : this.getFacetime().equals(other.getFacetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFilepath() == null) ? 0 : getFilepath().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getUp() == null) ? 0 : getUp().hashCode());
        result = prime * result + ((getFacetime() == null) ? 0 : getFacetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", filepath=").append(filepath);
        sb.append(", result=").append(result);
        sb.append(", up=").append(up);
        sb.append(", facetime=").append(facetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}