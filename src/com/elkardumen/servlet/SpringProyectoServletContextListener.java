package com.elkardumen.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.elkardumen.thread.HiloSiguientesPuntosGraficas;

public class SpringProyectoServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Generando el ServletContext ");
	}	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Destruyendo el Thread activo");
		HiloSiguientesPuntosGraficas.pararHilo();

	}

	

}
