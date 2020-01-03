package edu.dlnu.oa.assetTsets;

import edu.dlnu.oa.asset.pojo.Asset;
import edu.dlnu.oa.asset.service.AssetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class assetTest {
    @Autowired
    private AssetService assetService;
    @Test
    void contextLoads() {
    }
    @Test
    void get(){
        Asset asset = new Asset(1,"水杯","家具类","个",100.3,50);
        int i = assetService.insertAsset(asset);
        System.out.print(i);
    }
    @Test
    void findAllAsset(){
        List<Asset> allAsset = assetService.findAllAsset();
        for (Asset asset : allAsset) {
           System.out.printf(asset.toString());
        }
    }
    @Test
    void deleteAssetById(){
        int i = 2;
        int i1 = assetService.deleteAssetById(i);
        System.out.println(i1);
    }
    @Test
    void updateAsset(){
        Asset asset = new Asset(8,"花盆","家具类","个",10.6,50);
        int i = assetService.updateAsset(asset);
        System.out.print(i);

    }
}
