package edu.dlnu.oa.asset.mapper;

import edu.dlnu.oa.asset.pojo.Asset;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AssetMapper {
    @Insert("insert into asset values(default, #{assetName},#{assetClasses},#{assetSpecification},#{assetUnitPrice},#{assetInventory})")
    int insertAsset(Asset asset);

    @Select("select * from asset")
    List<Asset> findAllAsset();

    @Select("SELECT asset_id ,asset_name FROM asset where asset_id>0")
    List<Map<String,Object>> getAssetIdAndAssetName();


    @Delete("delete from asset where asset_id = #{id} ")
    int deleteAssetById(int id);

    @Update("UPDATE asset SET asset.asset_name= #{assetName},asset.asset_classes=#{assetClasses},asset.asset_specification=#{assetSpecification},asset.asset_unit_price=#{assetUnitPrice},asset.asset_inventory=#{assetInventory} \n" +
            "WHERE asset.asset_id = #{assetId}")
    int updateAsset(Asset asset);
}
