package edu.dlnu.oa.asset.pojo;

public class Asset {
    private Integer assetId;//资产编号
    private String assetName;//资产名称
    private  String assetClasses;//资产类别
    private  String assetSpecification;//资产规格（个，本，台）
    private  double assetUnitPrice;//资产单价
    private  Integer assetInventory;//资产库存数量


    public Asset() {
    }

    public Asset(Integer assetId) {
        this.assetId = assetId;
    }


    public Asset(String assetName) {
        this.assetName = assetName;
    }

    public Asset(String assetName, String assetClasses, String assetSpecification, double assetUnitPrice, Integer assetInventory) {
        this.assetName = assetName;
        this.assetClasses = assetClasses;
        this.assetSpecification = assetSpecification;
        this.assetUnitPrice = assetUnitPrice;
        this.assetInventory = assetInventory;
    }

    public Asset(Integer assetId, String assetName, String assetClasses, String assetSpecification, double assetUnitPrice, Integer assetInventory) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetClasses = assetClasses;
        this.assetSpecification = assetSpecification;
        this.assetUnitPrice = assetUnitPrice;
        this.assetInventory = assetInventory;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetClasses() {
        return assetClasses;
    }

    public void setAssetClasses(String assetClasses) {
        this.assetClasses = assetClasses;
    }

    public String getAssetSpecification() {
        return assetSpecification;
    }

    public void setAssetSpecification(String assetSpecification) {
        this.assetSpecification = assetSpecification;
    }

    public double getAssetUnitPrice() {
        return assetUnitPrice;
    }

    public void setAssetUnitPrice(double assetUnitPrice) {
        this.assetUnitPrice = assetUnitPrice;
    }

    public Integer getAssetInventory() {
        return assetInventory;
    }

    public void setAssetInventory(Integer assetInventory) {
        this.assetInventory = assetInventory;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetId=" + assetId +
                ", assetName='" + assetName + '\'' +
                ", assetClasses='" + assetClasses + '\'' +
                ", assetSpecification='" + assetSpecification + '\'' +
                ", assetUnitPrice=" + assetUnitPrice +
                ", assetInventory=" + assetInventory +
                '}';
    }
}
