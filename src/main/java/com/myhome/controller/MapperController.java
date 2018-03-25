package com.myhome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.service.SampleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MapperController {
	
	private static final Logger logger = LoggerFactory.getLogger(MapperController.class);
	
	@Resource
    private SampleService sampleService;
	
	@RequestMapping(value = "/")
	public String sample(Model model) throws Exception {
		logger.info("========> SamepleController");
		
		System.out.println("=====mapper0====");

		return "sample2";
	}
    
	@RequestMapping(value = "/sample.do")
	public String sampleOne(Model model) throws Exception {
		logger.info("========> SamepleController");
		
		System.out.println("=====mapper1====>" + sampleService.getTime());
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		commandMap.put("phone", "1234");
		
		List<Map<String, Object>> list = sampleService.selectSampleList(commandMap);
		model.addAttribute("list", list);

		return "sample2";
	}
	
	@RequestMapping(value = "/sample/sampleList.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> sample2(@RequestBody List<Map<String, Object>> body, Model model) throws Exception {
		logger.info("========> SamepleController");
		
		System.out.println("=====mapper2====>" + sampleService.getTime());
		System.out.println("=====Rquest Param====>" + body);
		System.out.println("=====Rquest Param====>" + body.get(0).get("name"));
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		commandMap.put("phone", "1234");
		
		List<Map<String, Object>> list = sampleService.selectSampleList(commandMap);
		model.addAttribute("list", list);

		return list;	//"sample2";
	}
	
	@RequestMapping(value = "/sample/sampleList1.do")
	public String sampleList1(@RequestParam String name, Model model) throws Exception {
		logger.info("========> SamepleController");
		
		System.out.println("=====mapper3====>" + sampleService.getTime());
		System.out.println("=====Rquest Param====>" + name);
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		commandMap.put("phone", "1234");
		
		List<Map<String, Object>> list = sampleService.selectSampleList(commandMap);
		model.addAttribute("list", list);

		return "sample2";
	}
	
}
