package com.bus.dao;

import java.util.List;

import com.bus.mapper.IRowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql,IRowMapper<T> mapper,Object... parameters);
	int insert(String sql,Object... parameters);
	int update(String sql,Object... parameters);
	int delete(String sql,Object... parameters);
}
