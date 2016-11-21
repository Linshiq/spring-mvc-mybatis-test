package lsq.service.dao;

import java.util.List;

import lsq.model.LdpaZhhaoye;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月22日 上午11:14:00 
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
 *         <li>2016年10月22日-上午11:14:00</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public interface LdpaZhhaoyeServiceDao {

	 List<LdpaZhhaoye> selectAllInfo();
	 
	 List<LdpaZhhaoye> selectByMonth(String month);
	 
	 int insertSelective(LdpaZhhaoye record);
	 
	 int insert(LdpaZhhaoye record);
}
