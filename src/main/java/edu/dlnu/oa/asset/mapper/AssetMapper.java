package edu.dlnu.oa.asset.mapper;

import edu.dlnu.oa.asset.pojo.Asset;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AssetMapper {
    @Insert("insert into asset values(default, #{assetName},#{assetClasses},#{assetSpecification},#{assUnitPrice},#{assetInventory})")
    int insertAsset(Asset asset);

    @Select("select * from asset")
    List<Asset> findAllAsset();

    @Delete("delete from asset where asset_id = #{id} ")
    int deleteAssetById(int id);

    @Update("UPDATE asset SET asset.asset_name= #{assetName},asset.asset_classes=#{assetClasses} ,asset.asset_inventory=#{assetInventory} \n" +
            "WHERE asset.asset_id = #{assetId}")
    int updateAsset(Asset asset);
}