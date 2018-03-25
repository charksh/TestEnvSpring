package com.myhome.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper --> 어떨때 사용하는가 ? 사용안해도 잘 돌아감
public interface SampleMapper {
	
	@Select("select now()")
	public String getTime() throws Exception;
	
	public List<Map<String, Object>> selectSampleList(Map<String, Object> map) throws Exception;
}
