package lsq.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lsq.model.LdpaMtxfjlb;
import lsq.service.dao.ArticleServiceDao;
import lsq.service.dao.LdpaMtxfjlServiceDao;
import lsq.service.dao.LdpaZhhaoyeServiceDao;
import lsq.service.dao.UserServiceDao;
import lsq.utils.CommUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath*:spring-mybatis.xml" })
public class TestMybatis {
	UserServiceDao usd;
	ArticleServiceDao ar;
	LdpaMtxfjlServiceDao ldpaMtxfjlService;
	LdpaZhhaoyeServiceDao ldpaZhhaoyeService;

	public  LdpaZhhaoyeServiceDao getLdpaZhhaoyeService() {
		return ldpaZhhaoyeService;
	}
	@Autowired
	public  void setLdpaZhhaoyeService(LdpaZhhaoyeServiceDao ldpaZhhaoyeService) {
		this.ldpaZhhaoyeService = ldpaZhhaoyeService;
	}
	public LdpaMtxfjlServiceDao getLdpaMtxfjlService() {
		return ldpaMtxfjlService;
	}

	@Autowired
	public void setLdpaMtxfjlService(LdpaMtxfjlServiceDao ldpaMtxfjlService) {
		this.ldpaMtxfjlService = ldpaMtxfjlService;
	}

	@Test
	public void test() {
		//取出初始数据
		List<LdpaMtxfjlb> LdpaMtxfjlbList = ldpaMtxfjlService.selectAllInfo();
		
		Map<String,Integer> map = new HashMap<>();		
		//将日期相同的数据进行相加
		List<String> same = new ArrayList<>();//接收重复数据的ID
		boolean flag = false;				  //重复标志
		String name = "";					  //map键值
		int sum = 1;				          //重复出现次数
		for(LdpaMtxfjlb l:LdpaMtxfjlbList){   
			
			for(String s:same){ 			  //检测是否出现重复数据
				if(l.getId().equals(s)){
					flag = true;			  //发现重复ID则跳过此次循环
					break;
				}
			}
			
			if(flag){
				flag = false;
				continue;
			}
			
			name = CommUtil.getSimpleDateFormat(l.getDate());
			for(LdpaMtxfjlb lm:LdpaMtxfjlbList){
				
				if(l.getId().equals(lm.getId())){//不与自己比较
					continue;
				}else if(l.getDate().equals(lm.getDate())){//检测相同日期的选项
					sum ++;
					same.add(lm.getId());		//将已经匹配过的ID加入same中
				}
			}
			map.put(name, sum);			//登记到map
			sum = 1;					//重置sum
		}
		
		for (Map.Entry<String,Integer> entry : map.entrySet()) { //遍历输出
			  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		}
		  
		
	}
}
