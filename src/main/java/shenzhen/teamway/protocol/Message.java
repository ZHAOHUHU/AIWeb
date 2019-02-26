package shenzhen.teamway.protocol;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 11:34
 **/
public class Message implements Serializable {

    private static final long serialVersionUID = -2106813038531745257L;
    private byte head = 1;
    private byte headLength = 10;
    private int requestType;
    private int totalLength;
    private int taskId;
    private int width=0;
    private int high=0;
    private int bodyLength;
    private byte[] messageBody;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte getHead() {
        return head;
    }

    public void setHead(byte head) {
        this.head = head;
    }

    public byte getHeadLength() {
        return headLength;
    }

    public void setHeadLength(byte headLength) {
        this.headLength = headLength;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public byte[] getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(byte[] messageBody) {
        this.messageBody = messageBody;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    public Message(byte head, byte headLength, int requestType, int totalLength, int taskId, int width, int high, int bodyLength, byte[] messageBody) {
        this.head = head;
        this.headLength = headLength;
        this.requestType = requestType;
        this.totalLength = totalLength;
        this.taskId = taskId;
        this.width = width;
        this.high = high;
        this.bodyLength = bodyLength;
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "Message{" +
                "head=" + head +
                ", headLength=" + headLength +
                ", requestType=" + requestType +
                ", totalLength=" + totalLength +
                ", messageBody=" + Arrays.toString(messageBody) +
                '}';
    }
}