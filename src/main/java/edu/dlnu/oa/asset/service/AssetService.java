package edu.dlnu.oa.asset.service;

import edu.dlnu.oa.asset.pojo.Asset;

import java.util.List;
import java.util.Map;


public interface AssetService {
    int insertAsset(Asset asset);
    List<Asset> findAllAsset();
    int deleteAssetById(int id);
    int updateAsset(Asset asset);
    List<Map<String,Object>> getAssetIdAndName();

}
