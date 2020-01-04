package edu.dlnu.oa.asset.controller;

import edu.dlnu.oa.asset.pojo.Asset;
import edu.dlnu.oa.asset.service.AssetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wuhan
 * @date 2019/12/20 21:01
 */
@RestController
@RequestMapping("/api")
public class AssetController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssetService service;

    @RequestMapping(value = "/asset/add", method = POST)
    public int add(@RequestBody Asset asset ){
        return service.addAsset(asset);
    }

    @RequestMapping(value = "/asset/query", method=POST)
    public  List<Asset>  query() {
        List<Asset> list=service.queryAsset();
        return list;
    }

    @RequestMapping(value = "/asset/update", method=POST)
    public  int update(@RequestBody Asset asset) {
        return service.updateAsset(asset);
    }


    @RequestMapping(value = "/asset/delete/{assetId}", method= POST)
    public  int delete(@PathVariable Integer assetId) {
        return service.deleteAsset(assetId);
    }

    @RequestMapping(value = "/asset/queryById/{assetId}", method=POST)
    public  Asset queryById(@PathVariable Integer assetId) {
        return  service.queryAssetById(assetId);
    }


//    @RequestMapping(value = "/asset/queryByName/{assetName}", method=POST)
//    public  List<Asset> queryByName(@PathVariable String assetName) {
//        return  service.queryAssetByName(assetName);
//    }

    @RequestMapping(value = "/asset/queryByName", method=POST)
    public  List<Asset> queryByName(@RequestBody Map<String,Object> info) {
        List<Asset> list=service.queryAssetByName(info.get("assetName").toString());
        return list;
//        return  service.queryAssetByName(assetName);
    }

}
