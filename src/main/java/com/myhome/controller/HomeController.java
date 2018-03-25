package com.myhome.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myhome.service.SampleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
    private SampleService sampleService;
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String sample(Model model) {
    	logger.info("====1====> / GET");
    	
    	model.addAttribute("serverTime", "1234");
    	return "sample";
    }
    
	@RequestMapping(value = "/home2")	//sample/sampleList.do
	public String sampleList(Model model) throws Exception {
		logger.info("====2====> /sample/sampleList.do");
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		commandMap.put("phone", "1234");
		
		List<Map<String, Object>> list = sampleService.selectSampleList(commandMap);
		
		model.addAttribute("list", list);

		return "sample";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		 
		try {
			sendGet();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
        String fullPath = "test.txt";
        File file = new File(fullPath);

	
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("downloadFile", file);
		
		return "home";
	}
	
    private static final String USER_AGENT = "Mozila/5.0";
    private static final String GET_URL = "https://blockchain.info/ko/rawblock/0000000000000bae09a7a393a8acded75aa67e46cb81f7acaa5ad94f9eacd103";
//    private static final String GET_URL = "http://www.google.com"; 
	
    public void sendGet() throws ClientProtocolException, IOException {
        
        //http client 생성
        CloseableHttpClient httpClient = HttpClients.createDefault();
 
        //get 메서드와 URL 설정
        HttpGet httpGet = new HttpGet(GET_URL);
 
        //agent 정보 설정
        httpGet.addHeader("User-Agent", USER_AGENT);
//        httpGet.addHeader("Content-type", "application/json");

        //get 요청
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        
        System.out.println("::GET Response Status::");
        
        //response의 status 코드 출력
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        System.out.println(httpResponse.getStatusLine().getReasonPhrase());
        
//        String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        String json = "{\"hash\" : \"hash_1\", \"ver\" : \"ver_2\"}";
        
//        HashMap<String,String> map = new HashMap<String,String>();
        
        ObjectMapper mapper = new ObjectMapper();
//        Data data = mapper.readValue(json, Data.class);

        HashMap<String,String> map = mapper.readValue(json, HashMap.class);

//        System.out.println("=============================> " + data.getHash());
        System.out.println("=============================> " + map.get("ver"));
        
//        String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
//        System.out.println(jsonStr);
        
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, map);
        
        
        EntityUtils.consume(httpResponse.getEntity());
 
//        BufferedReader reader = new BufferedReader( new InputStreamReader( httpResponse.getEntity().getContent() ) );
// 
//        String inputLine;
//        StringBuffer response = new StringBuffer();
// 
//        while ((inputLine = reader.readLine()) != null) {
//            response.append(inputLine);
//        }
//        
//        reader.close();
 
        //Print result
//        System.out.println(response.toString());
        
        httpClient.close();
    }  
	
}
