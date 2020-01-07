package edu.dlnu.oa.carCenter.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RentList {
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "FMT+8"
    )
    private Integer rentId;
    private Integer rentEmpId;
    private Integer rentCarId;
    private String rentLine;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date rentStime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date rentOtime;

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getRentEmpId() {
        return rentEmpId;
    }

    public void setRentEmpId(Integer rentEmpId) {
        this.rentEmpId = rentEmpId;
    }

    public Integer getRentCarId() {
        return rentCarId;
    }

    public void setRentCarId(Integer rentCarId) {
        this.rentCarId = rentCarId;
    }

    public String getRentLine() {
        return rentLine;
    }

    public void setRentLine(String rentLine) {
        this.rentLine = rentLine;
    }

    public Date getRentStime() {
        return rentStime;
    }

    public void setRentStime(Date rentStime) {
        this.rentStime = rentStime;
    }

    public Date getRentOtime() {
        return rentOtime;
    }

    public void setRentOtime(Date rentOtime) {
        this.rentOtime = rentOtime;
    }

    public RentList() {
    }

    public RentList(Integer rentEmpId, Integer rentCarId, String rentLine, Date rentStime, Date rentOtime) {
        this.rentEmpId = rentEmpId;
        this.rentCarId = rentCarId;
        this.rentLine = rentLine;
        this.rentStime = rentStime;
        this.rentOtime = rentOtime;
    }

    public RentList(Integer rentId, Integer rentEmpId, Integer rentCarId, String rentLine, Date rentStime, Date rentOtime) {
        this.rentId = rentId;
        this.rentEmpId = rentEmpId;
        this.rentCarId = rentCarId;
        this.rentLine = rentLine;
        this.rentStime = rentStime;
        this.rentOtime = rentOtime;
    }
}
