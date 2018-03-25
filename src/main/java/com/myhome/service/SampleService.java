package com.myhome.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

public interface SampleService {
	
	public String getTime() throws Exception;
	
	public List<Map<String, Object>> selectSampleList(Map<String, Object> map) throws Exception;
}
