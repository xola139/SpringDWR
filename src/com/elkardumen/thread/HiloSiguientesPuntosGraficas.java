package com.elkardumen.thread;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;
import org.directwebremoting.WebContext;



public class HiloSiguientesPuntosGraficas implements Runnable {

	private static Logger logger = Logger.getLogger(HiloSiguientesPuntosGraficas.class);
	private WebContext wctx;
	private static LinkedBlockingQueue<String> toRead = new LinkedBlockingQueue<String>();
	
	private static Thread t1=null;
	
	public  HiloSiguientesPuntosGraficas(WebContext wctx) {
	
		this.wctx = wctx;
		
		/*Aqui podemos colocar algun Thread que lea algun archivo,
		 * socket,websocket.. etc que coloque informacion al LinkedBlockingQueue 
		 * ''toRead'' para que se peuda hacer el take a ese  LinkedBlockingQueue*/
		
		/*En esta ejemplo se simula que esta leyendo de algun archivo*/
		if(t1==null){
		   t1= new Thread(new Task(toRead));
		   t1.start();
		}
		  
		
	}

	
	public void run() {
		String cadena = "";

	
		System.out.println();
		System.out.println("*************************************************************");
		System.out.println("*************1.-Inicia ejecucion HiloSiguientesPuntosGraficas***");
		System.out.println("*************************************************************");
		System.out.println();
		try {
			
			
			
			while (toRead != null) {
				
				cadena=toRead.take();
				if (cadena.equals("FIN_TRANSMISION"))
					break;
	
				
				//System.out.println(cadena);
				enviaPintarSeries(cadena , wctx);
				
			}
			
		} catch (Exception e) {
			logger.info("Error " + e.getMessage());

		}

		System.out.println();
		System.out.println("*************************************************************");
		System.out.println("*************1.-Finaliza ejecucion HiloSiguientesPuntosGraficas***");
		System.out.println("*************************************************************");
		System.out.println();
		
		
	}
	
	
	public void enviaPintarSeries(String  linea ,WebContext wctx){
		
		
		final String finalLinea=linea;
		
		
		Browser.withPage(wctx.getCurrentPage(), new Runnable() {
			public void run() {
				ScriptSessions.addFunctionCall("enviaLinea",finalLinea);
			}
		});
		
	}
	
	public static void pararHilo() {
		try {
			
			/*Seteamos las variables par qe paren los ciclos infinitos*/
			Task.setActivo(false);
			
			toRead.put("FIN_TRANSMISION");
			

			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}



class Task implements Runnable{
	private  LinkedBlockingQueue<String> toRead = new LinkedBlockingQueue<String>();
    public static boolean activo=true;
	
    public Task(LinkedBlockingQueue<String> toRead){
    	this.toRead=toRead;
    }
    
	
	@Override
    public void run() {
        try{
        	
        	System.out.println("Iniciamos Simulacion a enviar datos al LinkedBlockingQueue");
        	
        	while(activo){
        		Thread.sleep(10000L);
        		toRead.put("{\"tipo\":\"grid\",\"fecha\":\""+new Date()+"\", \"folio\":\"123\",\"ip\":\"127.0.0.1\",\"mensaje\":\"Tiempo de espera agotado para esta solicitud\" }");	

        		long fechaX= new Date().getTime();
        		toRead.put("{\"tipo\":\"graficas\",\"valores\":[{\"x\":"+fechaX+", \"y\":"+aleatorio()+",\"numSerie\":0},{\"x\":"+fechaX+", \"y\":"+aleatorio()+",\"numSerie\":1},{\"x\":"+fechaX+", \"y\":"+aleatorio()+",\"numSerie\":2}]}");
        		
        	}
        	
        	System.out.println("Finalizamos Simulacion a enviar datos al LinkedBlockingQueue");
        	
        }catch(Exception e){
        	e.printStackTrace();
        	
        }
		
		
		
		
    }
	
	public int aleatorio(){
		int valueY = (int)(Math.random() * 6 + 1);
		return valueY;
	}
	
	public static boolean isActivo() {
		return activo;
	}

	public static void setActivo(boolean activo) {
		
		Task.activo = activo;
	}

	
	
}

