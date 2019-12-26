package edu.dlnu.oa.asset.controller;


import edu.dlnu.oa.asset.pojo.Asset;
import edu.dlnu.oa.asset.service.AssetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api")
public class AssetController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/asset",method = GET)
    public List<Asset> getAllAsset(){
        log.info("Asset被访问了");
        return assetService.findAllAsset();
    }

    @RequestMapping(value = "/asset/{id}",method = DELETE)
    public int deleteAssetById(@PathVariable int id){return assetService.deleteAssetById(id);}

    @RequestMapping(value = "/asset", method = POST)
    public int postAsset(@RequestBody Asset asset ){
        return assetService.insertAsset(asset);
    }

    @RequestMapping(value = "/asset" ,method = PUT)
    public int updateAsset(@RequestBody Asset asset){
        return assetService.updateAsset(asset);
    }




}
