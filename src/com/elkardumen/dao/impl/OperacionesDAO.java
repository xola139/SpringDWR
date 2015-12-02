package com.elkardumen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.elkardumen.bean.ValoresGrafica;
import com.elkardumen.dao.IOperacionesDAO;



public class OperacionesDAO extends JdbcDaoSupport implements IOperacionesDAO{

	
	public List<Object>  getValoresGraficaLinear() {
		
		List<Object> lstRetorno=new ArrayList<Object>();
		
	
	try{	
		String sql="Select color,registros,fecha "
				+ "From alguna_Tabla order by fecha asc";
		
		List<ValoresGrafica> lstResult = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<ValoresGrafica>(ValoresGrafica.class));
	
		return lstRetorno;
				
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
		
		
	}
	
	
	@Override
	public List<Object>  getValoresGrafica() {
		
	try{	
		List<Object> lstRetorno=new ArrayList<Object>();
		
		String sql="SELECT ntransacciones,tipotransaccion,fechaactual as fecha"
				+ " FROM "
				+ "Alguna_Tabla "
				+ " ORDER BY HORAINSERT asc";

		
		List<ValoresGrafica> lstResult = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<ValoresGrafica>(ValoresGrafica.class));
		return lstRetorno;
	
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
		
		
		
		
		
	}

	
	
}
