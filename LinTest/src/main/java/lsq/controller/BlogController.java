package lsq.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import api.bean.brainteasers.BrainTeasers;
import api.bean.hotwechat.HotWechat;
import api.bean.hotwechat.HotWechatInput;
import lsq.data.api.processing.BrainTeasersProcess;
import lsq.data.api.processing.HotWeChatApiProcess;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月18日 上午10:59:38 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       blog界面control控制器
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月18日-上午10:59:38</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/")
public class BlogController {

	Logger logger = Logger.getLogger(BlogController.class);
	
 	@RequestMapping("/blog")
 	public String getBlogIndex(Model model,@RequestParam(value = "num", required=false) String num){ //required为参数不一定需要传
 		
 		HotWechatInput input = new HotWechatInput();
 		
 		if(CommUtil.isNull(num)){
 			input.setNum("10");
 		}else{
 			input.setNum(num);
 		}
 		List<HotWechat> l = HotWeChatApiProcess.getHotWechatList(input);
 		
 		model.addAttribute("contentWeChatList", l) ;
 		
 		return "/WEB-INF/jsp/blog/blog_index";
 	}
 	
 	@RequestMapping("/blog/brain_teasers")
 	public String getBlogBrainTeasers(Model model){ //required为参数不一定需要传

 		BrainTeasers brainTeasers = BrainTeasersProcess.getBrainTeasersOne();
 		
 		model.addAttribute("brainTeasers", brainTeasers) ;
 		
 		return "/WEB-INF/jsp/blog/blog_brain_teasers";
 	}
}
