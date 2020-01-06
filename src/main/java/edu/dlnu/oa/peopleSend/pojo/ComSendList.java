package edu.dlnu.oa.peopleSend.pojo;

import org.springframework.data.relational.core.sql.In;

/**
 * 外派记录
 */
public class ComSendList {

    private Integer sendId;
    private Integer sendSpId;
    private Integer sendComId;
    private String sendPeopleName;
    private String sendComName;

    public ComSendList() {
    }

    public ComSendList(Integer sendSpId, Integer sendComId, String sendPeopleName, String sendComName) {
        this.sendSpId = sendSpId;
        this.sendComId = sendComId;
        this.sendPeopleName = sendPeopleName;
        this.sendComName = sendComName;
    }

    public ComSendList(Integer sendId, Integer sendSpId, Integer sendComId, String sendPeopleName, String sendComName) {
        this.sendId = sendId;
        this.sendSpId = sendSpId;
        this.sendComId = sendComId;
        this.sendPeopleName = sendPeopleName;
        this.sendComName = sendComName;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getSendSpId() {
        return sendSpId;
    }

    public void setSendSpId(Integer sendSpId) {
        this.sendSpId = sendSpId;
    }

    public Integer getSendComId() {
        return sendComId;
    }

    public void setSendComId(Integer sendComId) {
        this.sendComId = sendComId;
    }

    public String getSendPeopleName() {
        return sendPeopleName;
    }

    public void setSendPeopleName(String sendPeopleName) {
        this.sendPeopleName = sendPeopleName;
    }

    public String getSendComName() {
        return sendComName;
    }

    public void setSendComName(String sendComName) {
        this.sendComName = sendComName;
    }

    @Override
    public String toString() {
        return "ComSendList{" +
                "sendId=" + sendId +
                ", sendSpId=" + sendSpId +
                ", sendComId=" + sendComId +
                ", sendPeopleName='" + sendPeopleName + '\'' +
                ", sendComName='" + sendComName + '\'' +
                '}';
    }
}
