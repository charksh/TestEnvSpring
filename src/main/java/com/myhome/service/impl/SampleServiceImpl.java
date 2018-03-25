package com.myhome.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myhome.mapper.SampleMapper;
import com.myhome.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	
    @Resource
    private SampleMapper sampleMapper;
    
    @Override
    public String getTime() throws Exception {
    	return sampleMapper.getTime();
    }
    
	@Override
	public List<Map<String, Object>> selectSampleList(Map<String, Object> map) throws Exception {
		return sampleMapper.selectSampleList(map);
	}
}
