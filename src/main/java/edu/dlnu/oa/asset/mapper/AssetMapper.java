package edu.dlnu.oa.asset.mapper;

import edu.dlnu.oa.asset.pojo.Asset;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AssetMapper {

    //INSERT INTO asset VALUES (6,"diannao", "dianqilei","tai",3000,99)
    @Insert("insert into asset " +
            "values(default,#{assetName},#{assetClasses}," +
            "#{assetSpecification},#{assetUnitPrice},#{assetInventory})")
    int insert(Asset asset);// 与assetServiceImpl对应

    @Update("update asset set asset_name= #{assetName},asset_classes= #{assetClasses}," +
            "asset_specification= #{assetSpecification},asset_unit_price= #{assetUnitPrice}," +
            "asset_inventory= #{assetInventory} WHERE asset_id = #{assetId}")
    int update(Asset asset);


    @Update("update asset set asset_inventory = #{newInventory} where asset_id = #{assetId} ")
    int setNewInventory(@Param("assetId") Integer empId, @Param("newInventory") Integer newInventory);

//
//    @Update("update emp set emp_pwd = #{newPwd} where emp_id = #{empId} ")
//    int setNewPwd(@Param("empId") int empId, @Param("newPwd") String newPwd);

//    @Update("update asset set asset_inventory= #{assetInventory} WHERE asset_id = #{assetId}")
//    int updateInventory(Integer newInventory);

//
    @Delete("delete from asset where asset_id = #{id} ")
    int delete(Integer assetId);
    @Select("select * from asset where asset_id=#{assetId}")
    Asset queryById(Integer assetId);

    @Select("select * from asset where asset_name=#{assetName}")
    List<Asset> queryByName(String assetName);


    @Select("select * from asset")
    List<Asset> query();

}
