package edu.dlnu.oa.asset.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Consume {
    private Integer consumeId;//消耗编号
    private Integer consumeAssetId;
    private String  consumeAssetName;
    private  String consumeAssetClasses;
    private  Integer consumeEmpId;
    private  String consumeEmpName;
    private  Integer consumeNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date consumeDate;
    private String consumeInfo;

    public Integer getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(Integer consumeId) {
        this.consumeId = consumeId;
    }

    public Integer getConsumeAssetId() {
        return consumeAssetId;
    }

    public void setConsumeAssetId(Integer consumeAssetId) {
        this.consumeAssetId = consumeAssetId;
    }

    public String getConsumeAssetName() {
        return consumeAssetName;
    }

    public void setConsumeAssetName(String consumeAssetName) {
        this.consumeAssetName = consumeAssetName;
    }

    public String getConsumeAssetClasses() {
        return consumeAssetClasses;
    }

    public void setConsumeAssetClasses(String consumeAssetClasses) {
        this.consumeAssetClasses = consumeAssetClasses;
    }

    public Integer getConsumeEmpId() {
        return consumeEmpId;
    }

    public void setConsumeEmpId(Integer consumeEmpId) {
        this.consumeEmpId = consumeEmpId;
    }

    public String getConsumeEmpName() {
        return consumeEmpName;
    }

    public void setConsumeEmpName(String consumeEmpName) {
        this.consumeEmpName = consumeEmpName;
    }

    public Integer getConsumeNumber() {
        return consumeNumber;
    }

    public void setConsumeNumber(Integer consumeNumber) {
        this.consumeNumber = consumeNumber;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getConsumeInfo() {
        return consumeInfo;
    }

    public void setConsumeInfo(String consumeInfo) {
        this.consumeInfo = consumeInfo;
    }

    public Consume() {
    }

    public Consume(Integer consumeId, Integer consumeAssetId, String consumeAssetName, String consumeAssetClasses, Integer consumeEmpId, String consumeEmpName, Integer consumeNumber, Date consumeDate, String consumeInfo) {
        this.consumeId = consumeId;
        this.consumeAssetId = consumeAssetId;
        this.consumeAssetName = consumeAssetName;
        this.consumeAssetClasses = consumeAssetClasses;
        this.consumeEmpId = consumeEmpId;
        this.consumeEmpName = consumeEmpName;
        this.consumeNumber = consumeNumber;
        this.consumeDate = consumeDate;
        this.consumeInfo = consumeInfo;
    }

    public Consume(Integer consumeAssetId, String consumeAssetName, String consumeAssetClasses, Integer consumeEmpId, String consumeEmpName, Integer consumeNumber, Date consumeDate, String consumeInfo) {
        this.consumeAssetId = consumeAssetId;
        this.consumeAssetName = consumeAssetName;
        this.consumeAssetClasses = consumeAssetClasses;
        this.consumeEmpId = consumeEmpId;
        this.consumeEmpName = consumeEmpName;
        this.consumeNumber = consumeNumber;
        this.consumeDate = consumeDate;
        this.consumeInfo = consumeInfo;
    }

    @Override
    public String toString() {
        return "Consume{" +
                "consumeId=" + consumeId +
                ", consumeAssetId=" + consumeAssetId +
                ", consumeAssetName='" + consumeAssetName + '\'' +
                ", consumeAssetClasses='" + consumeAssetClasses + '\'' +
                ", consumeEmpId=" + consumeEmpId +
                ", consumeEmpName='" + consumeEmpName + '\'' +
                ", consumeNumber=" + consumeNumber +
                ", consumeDate=" + consumeDate +
                ", consumeInfo='" + consumeInfo + '\'' +
                '}';
    }
}
