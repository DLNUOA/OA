package edu.dlnu.oa.asset.service.serviceImpl;

import edu.dlnu.oa.asset.mapper.AssetMapper;
import edu.dlnu.oa.asset.pojo.Asset;

import edu.dlnu.oa.asset.service.AssetService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AssetServiceImpl implements AssetService {

    @Resource
    private AssetMapper assetMapper;
    @Override
    public int insertAsset(Asset asset){
        return assetMapper.insertAsset(asset);
    }

    @Override
    public List<Asset> findAllAsset(){return assetMapper.findAllAsset();}

    @Override
    public int deleteAssetById(int id){return assetMapper.deleteAssetById(id);}

    public int updateAsset(Asset asset){return assetMapper.updateAsset(asset);}
    public List<Map<String,Object>> getAssetIdAndName(){
        return assetMapper.getAssetIdAndAssetName();
    }
}
