package edu.dlnu.oa.zhanghantest;

import edu.dlnu.oa.asset.mapper.AssetMapper;
import edu.dlnu.oa.asset.pojo.Asset;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestAssetMapper {
    @Resource
    private AssetMapper mapper;

    @Test
    public  void testUpdate()
    {
        Asset asset=new Asset(4,"hhhGpp","hhh","hhh",200,100);
        mapper.update(asset);
    }
    @Test
    public  void testInsert()
    {
        Asset asset=new Asset("hhhtes222","hhh","hhh",200,100);
        mapper.insert(asset);
    }
    @Test
    public  void testDelete()
    {
        mapper.delete(8);
    }

    @Test
    public  void testQueryById()
    {
        Asset asset=mapper.queryById(2);
        System.out.println(asset);
    }

    @Test
    public  void testQueryByName()
    {
        List<Asset> list=mapper.queryByName("平板");
        for (Asset asset:list){
            System.out.println(asset);
        }
    }

    @Test
    public  void testQuery()
    {
        List<Asset> list=mapper.query();
        for (Asset asset:list){
            System.out.println(asset);
        }
    }



}
