package lsq.dao;

import java.util.Date;
import java.util.List;

import lsq.model.LdpaZhhaoye;

public interface LdpaZhhaoyeMapper {
    int deleteByPrimaryKey(Date date);

    int insert(LdpaZhhaoye record);

    int insertSelective(LdpaZhhaoye record);

    LdpaZhhaoye selectByPrimaryKey(Date date);
    
    List<LdpaZhhaoye> selectAllInfo();
    
    List<LdpaZhhaoye> selectByMonth(String month);

    int updateByPrimaryKeySelective(LdpaZhhaoye record);

    int updateByPrimaryKeyWithBLOBs(LdpaZhhaoye record);

    int updateByPrimaryKey(LdpaZhhaoye record);
}