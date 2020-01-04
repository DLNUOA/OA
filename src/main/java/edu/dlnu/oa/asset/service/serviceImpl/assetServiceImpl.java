package edu.dlnu.oa.asset.service.serviceImpl;

import edu.dlnu.oa.asset.mapper.AssetMapper;
import edu.dlnu.oa.asset.pojo.Asset;
import edu.dlnu.oa.asset.service.AssetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class assetServiceImpl implements AssetService {
    @Resource
    private AssetMapper mapper;

    @Override
    public int addAsset(Asset asset) {//具体的方法  与  AssetService  I  接口对应
         return mapper.insert(asset);//与AssetMapper对应
    }

    @Override
    public  int updateAsset(Asset asset)
    {
        return mapper.update(asset);
    }


    @Override
    public  int setInventory(Integer assetId,Integer newInventory){return mapper.setNewInventory(assetId,newInventory);}

    @Override
    public  int deleteAsset(Integer assetId)
    {
        return mapper.delete(assetId);
    }

    @Override
    public  Asset queryAssetById(Integer assetId)
    {
        return mapper.queryById(assetId);
    }

    @Override
    public  List<Asset> queryAssetByName(String  assetName)
    {
        return mapper.queryByName(assetName);
    }


    @Override
    public List<Asset> queryAsset()
    {
        return mapper.query();
    }


}
