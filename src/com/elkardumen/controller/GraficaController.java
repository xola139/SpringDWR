package com.elkardumen.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.elkardumen.thread.HiloSiguientesPuntosGraficas;

public class GraficaController {
	
	//@Autowired private IOperacionesDAO consultas;
	private static Logger logger = Logger.getLogger(GraficaController.class);
	private static Thread hiloSiguientesPuntos;
	
	public synchronized String getDatosInicialesLinear() {
		try{
			//List<Object>  resultado=consultas.getValoresGraficaLinear();
			
			String respuesta="[{\"name\": \" \u0026lt; 5\",\"pointStart\":0,\"data\": []},"
					+ "{\"name\": \"\u0026gt; 5\",\"pointStart\":0,\"data\": []}, "
					+ "{\"name\": \"\u0026lt; 18\",\"pointStart\":0,	\"data\": [	]}]";
			return  respuesta;
			
		}catch(Exception e){
			e.printStackTrace();
			return "Error en getDatosInicialesLinear";
		}
		
	}
	
	
	public synchronized String[] getDatosInicialesGrafica() {
		String respuesta[] = new String[2];
		//List<Object>  resultado=consultas.getValoresGrafica();

		
		String resp="[{\"name\":\"Inactivos\",\"type\":\"area\",\"color\":\"#FFD968\",\"fillColor\":{\"linearGradient\":{\"x1\":0,\"y1\":0,\"x2\":0,\"y2\":1},\"stops\":[[0,\"rgba(255, 193, 7,.5)\"],[1,\"rgba(255,212,84,.6)\"]]},\"pointInterval\":60000,\"pointStart\":0,\"showInLegend\":true,"
				+ "\"data\":[],\"yAxis\":0},"
				+ "{\"name\":\"Activos\",\"type\":\"area\",\"color\":\"#E58264\",\"fillColor\":{\"linearGradient\":{\"x1\":0,\"y1\":0,\"x2\":0,\"y2\":1},\"stops\":[[0,\"rgb(230, 74, 25)\"],[1,\"rgb(229,130,100)\"]]},\"pointInterval\":60000,\"pointStart\":0,\"showInLegend\":true,"
				+ "\"data\":[],\"yAxis\":1}]";
		
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
	
	
	
}
