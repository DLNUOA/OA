package edu.dlnu.oa.aff.service;

import edu.dlnu.oa.aff.pojo.Aff;

import java.util.List;

public interface AffService {

        int insertAff(Aff aff);

        List<Aff> queryAff();

        int deleteAffById(int affId);

        int updateAff(Aff aff);

        List<Aff> queryById(int affId);

}
