package shenzhen.teamway.model;

import java.io.Serializable;
import java.util.Date;

public class ResultInfo implements Serializable {
    private Integer resultId;

    private Integer taskType;

    private String cameraName;

    private String picturePath;

    private Integer status;

    private Date time;

    private String detectResult;

    private static final long serialVersionUID = 1L;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName == null ? null : cameraName.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDetectResult() {
        return detectResult;
    }

    public void setDetectResult(String detectResult) {
        this.detectResult = detectResult == null ? null : detectResult.trim();
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
        ResultInfo other = (ResultInfo) that;
        return (this.getResultId() == null ? other.getResultId() == null : this.getResultId().equals(other.getResultId()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getCameraName() == null ? other.getCameraName() == null : this.getCameraName().equals(other.getCameraName()))
            && (this.getPicturePath() == null ? other.getPicturePath() == null : this.getPicturePath().equals(other.getPicturePath()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getDetectResult() == null ? other.getDetectResult() == null : this.getDetectResult().equals(other.getDetectResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResultId() == null) ? 0 : getResultId().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getCameraName() == null) ? 0 : getCameraName().hashCode());
        result = prime * result + ((getPicturePath() == null) ? 0 : getPicturePath().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getDetectResult() == null) ? 0 : getDetectResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resultId=").append(resultId);
        sb.append(", taskType=").append(taskType);
        sb.append(", cameraName=").append(cameraName);
        sb.append(", picturePath=").append(picturePath);
        sb.append(", status=").append(status);
        sb.append(", time=").append(time);
        sb.append(", detectResult=").append(detectResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}