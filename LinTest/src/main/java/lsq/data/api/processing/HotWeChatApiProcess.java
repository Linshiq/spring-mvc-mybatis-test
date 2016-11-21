package lsq.data.api.processing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import api.Api;
import api.bean.hotwechat.HotWechat;
import api.bean.hotwechat.HotWechatInput;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月16日 下午4:11:26 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       微信热门精选API	
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月16日-下午4:11:26</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class HotWeChatApiProcess {
	
	private static String httpUrl = "http://apis.baidu.com/txapi/weixin/wxhot";
	
	//private String apiKey = "7063b8442dda944b646e0129fdadce5b";

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年11月16日-下午4:16:38</li>
	 *         <li>功能说明：调用API获取微信热门文章</li>
	 *         </p>
	 */
	private static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey", Api.baiduApiKey);
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	public static List<HotWechat> getHotWechatList(HotWechatInput input){
		
		List<HotWechat> hotWechatList = new ArrayList<>();	

		StringBuffer httpArg = new StringBuffer();
		
		if(CommUtil.isNull(input.getNum())){//组装响应信息
			return null;
		}else{
			httpArg.append("num=").append(input.getNum());
		}
		
		if(CommUtil.isNotNull(input.getRand())){
			httpArg.append("&rand=").append(input.getRand());
		}
		
		if(CommUtil.isNotNull(input.getPage())){
			httpArg.append("&page=").append(input.getPage());
		}
		
		if(CommUtil.isNotNull(input.getSrc())){
			httpArg.append("&src=").append(input.getSrc());
		}
		//创建一个Gson对象
		Gson gson = new Gson();
		JsonParser parse =new JsonParser();  //创建json解析器

        try {
        	 JsonObject jsonTop=(JsonObject) parse.parse(request(HotWeChatApiProcess.httpUrl, httpArg.toString()));  //创建jsonObject对象

        	// JsonElement json =  parse.parse(jsonTop.get("newslist").toString());//取出热门微信内容

        	 JsonArray jsonArray = parse.parse(jsonTop.get("newslist").toString()).getAsJsonArray();
    
        	 //遍历JsonArray对象     	
        	 Iterator it = jsonArray.iterator();
        	 while(it.hasNext()){
        		 JsonElement e = (JsonElement)it.next();
        		 HotWechat hotWechat = new HotWechat();
        		 //JsonElement转换为JavaBean对象
        		 hotWechat = gson.fromJson(e, HotWechat.class);
        		 //System.out.println(hotWechat.toString());
        		 hotWechatList.add(hotWechat);
        	 }
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } 
		
		return hotWechatList;
	}
	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年11月16日-下午4:16:38</li>
	 *         <li>功能说明：测试而已</li>
	 *         </p>
	 */
	public static void main(String[] args) {
		String httpUrl = "http://apis.baidu.com/txapi/weixin/wxhot";
		//String httpArg = "num=10";//"num=10&rand=1&word=%E7%9B%97%E5%A2%93%E7%AC%94%E8%AE%B0&page=1&src=%E4%BA%BA%E6%B0%91%E6%97%A5%E6%8A%A5"
		
		HotWechatInput input =  new HotWechatInput();
		
		input.setNum("10");
		//input.setWord("盗墓笔记");
		List<HotWechat> hotWechatList = HotWeChatApiProcess.getHotWechatList(input);
		for(HotWechat h:hotWechatList){
			System.out.println(h.toString());
		}
//		
//		//创建一个Gson对象
//		Gson gson = new Gson();
//		JsonParser parse =new JsonParser();  //创建json解析器
//
//        try {
//        	 JsonObject jsonTop=(JsonObject) parse.parse(jsonResult);  //创建jsonObject对象
//
//        	 JsonElement json =  parse.parse(jsonTop.get("newslist").toString());//去除热门微信内容
//
//        	 JsonArray jsonArray = json.getAsJsonArray();
//
//        	 //遍历JsonArray对象
//        	 HotWechat hotWechat = new HotWechat();
//        	 Iterator it = jsonArray.iterator();
//        	 while(it.hasNext()){
//        		 JsonElement e = (JsonElement)it.next();
//        	 //JsonElement转换为JavaBean对象
//        		 hotWechat = gson.fromJson(e, HotWechat.class);
//        		 System.out.println(hotWechat.toString());
//        	 }
//             
//        } catch (JsonIOException e) {
//            e.printStackTrace();
//        } catch (JsonSyntaxException e) {
//            e.printStackTrace();
//        } 
		
		
	}
		
}
