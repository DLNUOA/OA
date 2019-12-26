package edu.dlnu.oa.asset.pojo;



public class Asset{

    private Integer assetId;
    private String assetName;
    private String assetClasses;
    private String assetSpecification;
    private String assUnitPrice;
    private Integer assetInventory;

    public Asset() {
    }

    public Asset(String assetName, String assetClasses, String assetSpecification, String assUnitPrice, Integer assetInventory) {
        this.assetName = assetName;
        this.assetClasses = assetClasses;
        this.assetSpecification = assetSpecification;
        this.assUnitPrice = assUnitPrice;
        this.assetInventory = assetInventory;
    }

    public Asset(Integer assetId, String assetName, String assetClasses, String assetSpecification, String assUnitPrice, Integer assetInventory) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetClasses = assetClasses;
        this.assetSpecification = assetSpecification;
        this.assUnitPrice = assUnitPrice;
        this.assetInventory = assetInventory;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetClasses() {
        return assetClasses;
    }

    public String getAssetSpecification() {
        return assetSpecification;
    }

    public String getAssUnitPrice() {
        return assUnitPrice;
    }

    public Integer getAssetInventory() {
        return assetInventory;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAssetClasses(String assetClasses) {
        this.assetClasses = assetClasses;
    }

    public void setAssetSpecification(String assetSpecification) {
        this.assetSpecification = assetSpecification;
    }

    public void setAssUnitPrice(String assUnitPrice) {
        this.assUnitPrice = assUnitPrice;
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
                ", assUnitPrice='" + assUnitPrice + '\'' +
                ", assetInventory=" + assetInventory +
                '}';
    }
}

