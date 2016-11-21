package lsq.service.dao;

import java.util.Date;
import java.util.List;

import lsq.model.LdpaMtxfjlb;

public interface LdpaMtxfjlServiceDao {

	List<LdpaMtxfjlb> selectAllInfo();

	LdpaMtxfjlb selectByPrimaryKey(String id);

	List<LdpaMtxfjlb> selectByDate(Date date);

	List<LdpaMtxfjlb> selectByMonth(String month);
	
	int insertSelective(LdpaMtxfjlb record);
}
