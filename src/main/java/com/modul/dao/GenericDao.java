package com.modul.dao;

import java.util.List;

import com.modul.mapper.RowMapper;


public interface GenericDao <T>{
   <T>List <T> query(String sql,RowMapper<T>rowMapper,Object...Parameters);
   void update (String sql,Object...parameters);
   Long insert (String sql,Object...parameters);
   int count (String sql,Object...parameters);
}

