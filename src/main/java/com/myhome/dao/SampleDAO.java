package com.myhome.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.myhome.comm.dao.AbstractDAO;

@Repository
public class SampleDAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectSampleList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>)selectList("sample.selectSampleList", map);
	}
}
