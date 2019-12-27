package edu.dlnu.oa.carCenter.pojo;

import java.io.Serializable;

public class CarCenter {
    private Integer carId;
    private String carType;
    private String carNum;
    private String carPic;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public CarCenter() {
    }

    public CarCenter(String carType, String carNum, String carPic) {
        this.carType = carType;
        this.carNum = carNum;
        this.carPic = carPic;
    }

    public CarCenter(Integer carId, String carType, String carNum, String carPic) {
        this.carId = carId;
        this.carType = carType;
        this.carNum = carNum;
        this.carPic = carPic;
    }

    @Override
    public String toString() {
        return "CarCenter{" +
                "carId=" + carId +
                ", carType='" + carType + '\'' +
                ", carNum='" + carNum + '\'' +
                ", carPic='" + carPic + '\'' +
                '}';
    }
}
