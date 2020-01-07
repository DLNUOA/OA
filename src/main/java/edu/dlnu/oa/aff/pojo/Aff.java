package edu.dlnu.oa.aff.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Aff {

    private Integer affId;

    private String affName;

    private String affCont;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date affData;

    private Integer affEmpId;

    public Integer getAffId() {
        return affId;
    }

    public void setAffId(Integer affId) {
        this.affId = affId;
    }

    public String getAffName() {
        return affName;
    }

    public void setAffName(String affName) {
        this.affName = affName;
    }

    public String getAffCont() {
        return affCont;
    }

    public void setAffCont(String affCont) {
        this.affCont = affCont;
    }

    public Date getAffData() {
        return affData;
    }

    public void setAffData(Date affData) {
        this.affData = affData;
    }

    public Integer getAffEmpId() {
        return affEmpId;
    }

    public void setAffEmpId(Integer affEmpId) {
        this.affEmpId = affEmpId;
    }

    public Aff() {
    }
    public Aff(Integer affId, String affName, String affCont, Date affData, Integer affEmpId) {
        this.affId = affId;
        this.affName = affName;
        this.affCont = affCont;
        this.affData = affData;
        this.affEmpId = affEmpId;
    }

    public Aff(String affName, String affCont, Date affData, Integer affEmpId) {
        this.affName = affName;
        this.affCont = affCont;
        this.affData = affData;
        this.affEmpId = affEmpId;
    }

    @Override
    public String toString() {
        return "Aff{" +
                "affId=" + affId +
                ", affName='" + affName + '\'' +
                ", affCont='" + affCont + '\'' +
                ", affDate=" + affData +
                ", affEmpId=" + affEmpId +
                '}';
    }
}
