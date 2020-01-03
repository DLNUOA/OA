package edu.dlnu.oa.asset.service;

import edu.dlnu.oa.asset.pojo.Consume;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
public interface ConsumeService {

     int addConsume(Consume consume);
//    int updateConsume(Consume asset);
//    int deleteConsume(Integer assetId);
//    Consume queryConsumeById(Integer assetId);
      List<Consume> queryConsume();
}
