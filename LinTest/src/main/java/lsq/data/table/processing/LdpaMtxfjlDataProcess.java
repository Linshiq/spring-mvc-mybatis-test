package lsq.data.table.processing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import error.Error;
import lsq.bean.report.amount.AnnualReport;
import lsq.model.LdpaMtxfjlb;
import lsq.model.LdpaZhhaoye;
import lsq.service.dao.LdpaMtxfjlServiceDao;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月27日 上午11:40:54 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：LdpaMtxfjl信息处理
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月27日-上午11:40:54</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class LdpaMtxfjlDataProcess {

	private static LdpaMtxfjlServiceDao ldpaMtxfjlService;

	public LdpaMtxfjlServiceDao getLdpaMtxfjlService() {
		return ldpaMtxfjlService;
	}

	public void setLdpaMtxfjlService(LdpaMtxfjlServiceDao ldpaMtxfjlService) {
		LdpaMtxfjlDataProcess.ldpaMtxfjlService = ldpaMtxfjlService;
	}

	// 根据日期获取一天的报表(天)
	public static List<LdpaMtxfjlb> getOneDateData(Date date) {

		return ldpaMtxfjlService.selectByDate(date);
	}

	// 根据月份获取一个月的报表
	public static List<LdpaZhhaoye> getOneMonthData(String month) {	

		return LdpaZhhaoyeDataProcess.getOneMonthData(month);
	}

	// 获取每天消费总金额
	public static Map<String, List<AnnualReport>> getSpendingEveryDay() {
		// 查询消费记录表
		List<LdpaMtxfjlb> ldpaMtxfjlList = ldpaMtxfjlService.selectAllInfo();

		if (ldpaMtxfjlList.isEmpty())
			try {
				throw new Error("消费表为空");
			} catch (Error e) {
				e.printStackTrace();
			}

		String dayStr = CommUtil.getSimpleDateFormat(ldpaMtxfjlList.get(0).getDate());

		float totalConsumption = 0;

		Map<String, List<AnnualReport>> allMonthMap = new HashMap<>();

		List<AnnualReport> dayList = new ArrayList<>();

		AnnualReport annualReport = new AnnualReport();

		for (LdpaMtxfjlb l : ldpaMtxfjlList) {// 对每天消费收入金额进行统计
			String day = CommUtil.getSimpleDateFormat(l.getDate());
			if (!dayStr.equals(day)) {
				annualReport.setAmout(totalConsumption);
				annualReport.setDate(dayStr);
				annualReport.setYear(dayStr.substring(0, dayStr.lastIndexOf('-')));
				dayList.add(annualReport);
				if (!dayStr.substring(0, 7).equals(day.substring(0, 7))) {
					allMonthMap.put(dayStr.substring(dayStr.indexOf('-') + 1, dayStr.lastIndexOf('-')), dayList);
					dayList = new ArrayList<>();
				}
				annualReport = new AnnualReport();
				totalConsumption = 0;
				dayStr = day;
			}
			totalConsumption = totalConsumption + l.getExpenditure() - l.getIncome();
		}

		return allMonthMap;
	}

}
