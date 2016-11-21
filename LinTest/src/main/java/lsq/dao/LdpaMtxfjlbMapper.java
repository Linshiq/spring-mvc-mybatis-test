package lsq.dao;

import java.util.Date;
import java.util.List;

import lsq.model.LdpaMtxfjlb;

public interface LdpaMtxfjlbMapper {
    int deleteByPrimaryKey(String id);

    int insert(LdpaMtxfjlb record);

    int insertSelective(LdpaMtxfjlb record);

    LdpaMtxfjlb selectByPrimaryKey(String id);
    
    List<LdpaMtxfjlb> selectAllInfo();
    
    List<LdpaMtxfjlb> selectByDate(Date date);
    
    List<LdpaMtxfjlb> selectByMonth(String month);

    int updateByPrimaryKeySelective(LdpaMtxfjlb record);

    int updateByPrimaryKeyWithBLOBs(LdpaMtxfjlb record);

    int updateByPrimaryKey(LdpaMtxfjlb record);
}