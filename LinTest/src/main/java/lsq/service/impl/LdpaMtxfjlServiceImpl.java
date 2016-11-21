package lsq.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsq.dao.LdpaMtxfjlbMapper;
import lsq.model.LdpaMtxfjlb;
import lsq.service.dao.LdpaMtxfjlServiceDao;

@Service("ldpaMtxfjlService")
public class LdpaMtxfjlServiceImpl implements LdpaMtxfjlServiceDao {

	private LdpaMtxfjlbMapper ldpaMtxfjlbMapper; //必须为私有 视频教程55:47处
	
	
	public LdpaMtxfjlbMapper getLdpaMtxfjlbMapper() {
		return ldpaMtxfjlbMapper;
	}

	@Autowired
	public void setLdpaMtxfjlbMapper(LdpaMtxfjlbMapper ldpaMtxfjlbMapper) {
		this.ldpaMtxfjlbMapper = ldpaMtxfjlbMapper;
	}


	@Override
	public List<LdpaMtxfjlb> selectAllInfo() {
		
		return ldpaMtxfjlbMapper.selectAllInfo();
	}

	@Override
	public LdpaMtxfjlb selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return ldpaMtxfjlbMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaMtxfjlServiceDao#selectByDate(java.util.Date)
	 */
	@Override
	public List<LdpaMtxfjlb> selectByDate(Date date) {
		// TODO Auto-generated method stub
		return ldpaMtxfjlbMapper.selectByDate(date);
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaMtxfjlServiceDao#selectByMonth(java.lang.String)
	 */
	@Override
	public List<LdpaMtxfjlb> selectByMonth(String month) {
		// TODO Auto-generated method stub
		return ldpaMtxfjlbMapper.selectByMonth("%-"+month+"-%");
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaMtxfjlServiceDao#insertSelective(lsq.model.LdpaMtxfjlb)
	 */
	@Override
	public int insertSelective(LdpaMtxfjlb record) {	
		
		return ldpaMtxfjlbMapper.insertSelective(record);
	}

}
