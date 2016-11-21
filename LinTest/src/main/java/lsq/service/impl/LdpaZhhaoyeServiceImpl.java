package lsq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsq.dao.LdpaZhhaoyeMapper;
import lsq.model.LdpaZhhaoye;
import lsq.service.dao.LdpaZhhaoyeServiceDao;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月22日 上午11:15:14 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月22日-上午11:15:14</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Service("ldpaZhhaoyeService")
public class LdpaZhhaoyeServiceImpl implements LdpaZhhaoyeServiceDao {

	private LdpaZhhaoyeMapper ldpaZhhaoyeMapper;
	
	public LdpaZhhaoyeMapper getLdpaZhhaoyeMapper() {
		return ldpaZhhaoyeMapper;
	}
	@Autowired
	public void setLdpaZhhaoyeMapper(LdpaZhhaoyeMapper ldpaZhhaoyeMapper) {
		this.ldpaZhhaoyeMapper = ldpaZhhaoyeMapper;
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaZhhaoyeServiceDao#selectAllInfo()
	 */
	@Override
	public List<LdpaZhhaoye> selectAllInfo() {

		return ldpaZhhaoyeMapper.selectAllInfo();
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaZhhaoyeServiceDao#selectByMonth(java.lang.String)
	 */
	@Override
	public List<LdpaZhhaoye> selectByMonth(String month) {
	
		return ldpaZhhaoyeMapper.selectByMonth("%-"+month+"-%");
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaZhhaoyeServiceDao#insertSelective(lsq.model.LdpaZhhaoye)
	 */
	@Override
	public int insertSelective(LdpaZhhaoye record) {
		return ldpaZhhaoyeMapper.insertSelective(record);
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.LdpaZhhaoyeServiceDao#insert(lsq.model.LdpaZhhaoye)
	 */
	@Override
	public int insert(LdpaZhhaoye record) {

		return ldpaZhhaoyeMapper.insert(record);
	}

}
