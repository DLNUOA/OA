package edu.dlnu.oa.carCenter.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CarRent {
    private Integer carRentId;

    private String carRentLine;

    private String carRentInfo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date carApplyTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date carRentStime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date carRentOtime;

    private Integer carRentState;

    private Integer carId;

    private Integer empApplyId;

    private Integer empCheckmanId;

    public CarRent() {
    }

    public CarRent(String carRentLine, String carRentInfo, Date carApplyTime, Date carRentStime, Date carRentOtime, Integer carRentState, Integer carId, Integer empApplyId, Integer empCheckmanId) {
        this.carRentLine = carRentLine;
        this.carRentInfo = carRentInfo;
        this.carApplyTime = carApplyTime;
        this.carRentStime = carRentStime;
        this.carRentOtime = carRentOtime;
        this.carRentState = carRentState;
        this.carId = carId;
        this.empApplyId = empApplyId;
        this.empCheckmanId = empCheckmanId;
    }

    public CarRent(Integer carRentId, String carRentLine, String carRentInfo, Date carApplyTime, Date carRentStime, Date carRentOtime, Integer carRentState, Integer carId, Integer empApplyId, Integer empCheckmanId) {
        this.carRentId = carRentId;
        this.carRentLine = carRentLine;
        this.carRentInfo = carRentInfo;
        this.carApplyTime = carApplyTime;
        this.carRentStime = carRentStime;
        this.carRentOtime = carRentOtime;
        this.carRentState = carRentState;
        this.carId = carId;
        this.empApplyId = empApplyId;
        this.empCheckmanId = empCheckmanId;
    }

    @Override
    public String toString() {
        return "CarRent{" +
                "carRentId=" + carRentId +
                ", carRentLine='" + carRentLine + '\'' +
                ", carRentInfo='" + carRentInfo + '\'' +
                ", carApplyTime=" + carApplyTime +
                ", carRentStime=" + carRentStime +
                ", carRentOtime=" + carRentOtime +
                ", carRentState=" + carRentState +
                ", carId=" + carId +
                ", empApplyId=" + empApplyId +
                ", empCheckmanId=" + empCheckmanId +
                '}';
    }

    public Integer getCarRentId() {
        return carRentId;
    }

    public void setCarRentId(Integer carRentId) {
        this.carRentId = carRentId;
    }

    public String getCarRentLine() {
        return carRentLine;
    }

    public void setCarRentLine(String carRentLine) {
        this.carRentLine = carRentLine == null ? null : carRentLine.trim();
    }

    public String getCarRentInfo() {
        return carRentInfo;
    }

    public void setCarRentInfo(String carRentInfo) {
        this.carRentInfo = carRentInfo == null ? null : carRentInfo.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    public Date getCarApplyTime() {
        return carApplyTime;
    }

    public void setCarApplyTime(Date carApplyTime) {
        this.carApplyTime = carApplyTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    public Date getCarRentStime() {
        return carRentStime;
    }

    public void setCarRentStime(Date carRentStime) {
        this.carRentStime = carRentStime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    public Date getCarRentOtime() {
        return carRentOtime;
    }

    public void setCarRentOtime(Date carRentOtime) {
        this.carRentOtime = carRentOtime;
    }

    public Integer getCarRentState() {
        return carRentState;
    }

    public void setCarRentState(Integer carRentState) {
        this.carRentState = carRentState;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getEmpApplyId() {
        return empApplyId;
    }

    public void setEmpApplyId(Integer empApplyId) {
        this.empApplyId = empApplyId;
    }

    public Integer getEmpCheckmanId() {
        return empCheckmanId;
    }

    public void setEmpCheckmanId(Integer empCheckmanId) {
        this.empCheckmanId = empCheckmanId;
    }
}