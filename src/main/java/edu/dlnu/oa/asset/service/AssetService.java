package edu.dlnu.oa.asset.service;

import edu.dlnu.oa.asset.pojo.Asset;

import java.util.List;

public interface AssetService {
     int addAsset(Asset asset);
     int updateAsset(Asset asset);
     int deleteAsset(Integer assetId);
     Asset queryAssetById(Integer assetId);
     List<Asset> queryAssetByName(String assetName);
     List<Asset> queryAsset();


}
