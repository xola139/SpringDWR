package com.elkardumen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.elkardumen.bean.DataGrafica;
import com.elkardumen.bean.FillColor;
import com.elkardumen.bean.LinearGradient;
import com.elkardumen.dao.IOperacionesDAO;
import com.elkardumen.thread.HiloSiguientesPuntosGraficas;

public class GraficaController {
	
	@Autowired private IOperacionesDAO consultas;
	private static Logger logger = Logger.getLogger(GraficaController.class);
	private static Thread hiloSiguientesPuntos;
	
	public synchronized String getDatosInicialesLinear() {
		try{
			//List<Object>  resultado=consultas.getValoresGraficaLinear();

			
			long datelong=new Date().getTime();
			long datelong2=datelong-100000L;
			long datelong3=datelong-200000L;
			String respuesta="[{\"name\": \" \u0026lt; 5\",\"data\": [["+datelong3+", 0],["+datelong2+", 0],["+datelong+", 10]]},"
					+ "{\"name\": \"\u0026gt; 5\",\"data\": [["+datelong3+", 0],["+datelong2+", 10],["+datelong+", 10]]}, "
					+ "{\"name\": \"\u0026lt; 18\",	\"data\": [	["+datelong3+", 2],["+datelong2+", 3],["+datelong+", 10]]}]";
			return  respuesta;
			
		}catch(Exception e){
			e.printStackTrace();
			return "Error en getDatosInicialesLinear";
		}
		
	}
	
	
	public synchronized String[] getDatosInicialesGrafica() {
		String respuesta[] = new String[2];
		List<Object>  resultado=consultas.getValoresGrafica();


		long datelong=new Date().getTime();
		long datelong2=datelong-100000L;
		
		String resp="[{\"name\":\"Inactivos\",\"type\":\"area\",\"color\":\"#FFD968\",\"fillColor\":{\"linearGradient\":{\"x1\":0,\"y1\":0,\"x2\":0,\"y2\":1},\"stops\":[[0,\"rgba(255, 193, 7,.5)\"],[1,\"rgba(255,212,84,.6)\"]]},\"pointInterval\":60000,\"pointStart\":0,\"showInLegend\":true,"
				+ "\"data\":[["+datelong2+",0],["+datelong+",0]],\"yAxis\":0},"
				+ "{\"name\":\"Activos\",\"type\":\"area\",\"color\":\"#E58264\",\"fillColor\":{\"linearGradient\":{\"x1\":0,\"y1\":0,\"x2\":0,\"y2\":1},\"stops\":[[0,\"rgb(230, 74, 25)\"],[1,\"rgb(229,130,100)\"]]},\"pointInterval\":60000,\"pointStart\":0,\"showInLegend\":true,"
				+ "\"data\":[["+datelong2+",0],["+datelong+",0]],\"yAxis\":1}]";
		
		respuesta[0] = "SpringDWRs";
		respuesta[1] = resp;
		
		
		
		
		
		
		return respuesta;
	}

	
	public synchronized void iniciaValoresSecuenciales() {
		try {
			// Aplicacamos el Singleton Pattern
			if (hiloSiguientesPuntos == null) {
				System.out.println("Ejecutando una vez regresaValoresSecuenciales....");
				logger.info("Ejecutando una vez regresaValoresSecuenciales....");
				WebContext wctx = WebContextFactory.get();
				hiloSiguientesPuntos = new Thread(
						new HiloSiguientesPuntosGraficas( wctx));
				hiloSiguientesPuntos.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
	}

	public String [] getColor(String nombre,String tipo){
		String color[]=new String[6];
		
		if(tipo.equals("normal")){
			color[0]="#FFD968";
			color[1]="rgba(255, 193, 7,.5)";
			color[2]="rgba(255,212,84,.6)";
			
			color[3]="#E58264";
			color[4]="rgb(230, 74, 25)";
			color[5]="rgb(229,130,100)";	
		}
		
		return color;
	}
	
	public Object[] generaDatosGrafica( List<Object> losDatos,String titleGrafica1,String titleGrafica2,String color[]){
		
		Object[] elJSON = new Object[2];
		DataGrafica datosTRX=new DataGrafica();
		DataGrafica datosMNT=new DataGrafica();
		
		/*Configuracion opcional*/
		LinearGradient linea=new LinearGradient();
		linea.setX1(0);
		linea.setY1(0);
		linea.setX2(0);
		linea.setY2(1);
		
		FillColor fillcolorTRX=new FillColor();
		Object[] objectArrayColorTRX = new Object[2];
		List<Object> objTRX=new ArrayList<Object>();
		
		FillColor fillcolorMNT=new FillColor();
		Object[] objectArrayColorMNT=null;
		List<Object> objMNT=null;
		/*Fin Configuracion opcional*/
		
		//*****Configuramos  para la grafica  TRX*******
		//********************************************************************
		//Configuracion color degradado
		objectArrayColorTRX = new Object[2];
		objTRX=new ArrayList<Object>();
		objectArrayColorTRX[0]=0;
		objectArrayColorTRX[1]=color[1];
		objTRX.add(objectArrayColorTRX);
		objectArrayColorTRX = new Object[2];
		objectArrayColorTRX[0]=1;
		objectArrayColorTRX[1]=color[2];
		objTRX.add(objectArrayColorTRX);
		fillcolorTRX.setStops(objTRX);
		fillcolorTRX.setLinearGradient(linea);
		//Fin Configuracion color degradado
		
		datosTRX.setName(titleGrafica1);		//nombre de la grafica
		datosTRX.setType("area");				//Tipo grafica
		datosTRX.setColor(color[0]);			//Color linea grafica
		datosTRX.setFillColor(fillcolorTRX);	//El degradado configurador previo
		datosTRX.setPointInterval(60000L);
		datosTRX.setPointStart(0);
		datosTRX.setShowInLegend(true);
		datosTRX.setData(losDatos.get(0));		//Datos en json de la lista losDatos 0
		elJSON[0]=datosTRX;
		
		//*****Configuramos  para la grafica  Montos*******
		//********************************************************************
		//Configuracion color degradado
		objectArrayColorMNT = new Object[2];
		objMNT=new ArrayList<Object>();
		objectArrayColorMNT[0]=0;
		objectArrayColorMNT[1]=color[4];
		objMNT.add(objectArrayColorMNT);
		objectArrayColorMNT = new Object[2];
		objectArrayColorMNT[0]=1;
		objectArrayColorMNT[1]=color[5];
		objMNT.add(objectArrayColorMNT);
		fillcolorMNT.setStops(objMNT);
		fillcolorMNT.setLinearGradient(linea);
		//Fin Configuracion color degradado		
		
		datosMNT.setName(titleGrafica2);			//nombre de la grafica
		datosMNT.setType("area");					//Tipo grafica
		datosMNT.setColor(color[3]);				//Color linea grafica
		datosMNT.setFillColor(fillcolorMNT);		//El degradado configurador previo
		datosMNT.setyAxis(1);					
		datosMNT.setPointInterval(60000L);			
		datosMNT.setPointStart(0);			
		datosMNT.setShowInLegend(true);	
		datosMNT.setData(losDatos.get(1));			//Datos en json de la lista losDatos 1	
		elJSON[1]=datosMNT;
		
		return elJSON;
	}
	
	
	
}
