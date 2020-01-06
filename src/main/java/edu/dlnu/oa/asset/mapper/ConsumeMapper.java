package edu.dlnu.oa.asset.mapper;

import edu.dlnu.oa.asset.pojo.Consume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsumeMapper {


    //INSERT INTO asset VALUES (6,"diannao", "dianqilei","tai",3000,99)
    @Insert("insert into consume " +
            "values(default,#{consumeAssetId},#{consumeAssetName}," +
            "#{consumeAssetClasses},#{consumeEmpId},#{consumeEmpName}," +
            "#{consumeNumber},#{consumeDate},#{consumeInfo})")
    int insert(Consume consume);// 与assetServiceImpl对应


//    @Select("select * from asset where asset_id=#{assetId}")
//    Asset queryById(Integer assetId);

    @Select("select * from consume")
    List<Consume> query();

}
