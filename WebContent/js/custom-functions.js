jQuery(document).ready(function(){
	
	//Traemos los valores iniciales de la grafica
	cargaGrafica.getDatosInicialesGrafica({
		callback:getCargaInicialGraficaCallBack
	});
	
	
	cargaGrafica.getDatosInicialesLinear({
		callback:getCargaInicialGraficaLinearCallBack
	});
	
	
	//Hacemos el llamado del metodo inciaValoresSecuenciales que contiene un Thread 
	//para enviar los valores secuenciales
	cargaGrafica.iniciaValoresSecuenciales();
	

});


//Manejador de errores de DWR para javascript
function errh(msg, exc) {
	  console.log("Error message is: " + msg +
			  " - Error Details: " + dwr.util.toDescriptiveString(exc, 2));
	}


//Funcion que utilza DWR para enviar la linea JSON
function enviaLinea(data){
	
	var theJSON=JSON.parse(data);
	if(theJSON.tipo==='grid'){
		dibujaRow(data)
	}else{
		
		/*Puntos Grafica Linear*/
		pintaPuntoEnSerie(theJSON.valores[0].y,theJSON.valores[0].x,theJSON.valores[0].numSerie,"Linear");
		pintaPuntoEnSerie(theJSON.valores[1].y,theJSON.valores[1].x,theJSON.valores[1].numSerie,"Linear");
		pintaPuntoEnSerie(theJSON.valores[2].y,theJSON.valores[2].x,theJSON.valores[2].numSerie,"Linear");
		
		/*Puntos grafica area*/
		pintaPuntoEnSerie(theJSON.valores[0].y,theJSON.valores[0].x,theJSON.valores[0].numSerie,"Area");
		pintaPuntoEnSerie(theJSON.valores[1].y,theJSON.valores[1].x,theJSON.valores[1].numSerie,"Area");
	}
	
}


function dibujaRow(data){
	var theJSON=JSON.parse(data);
	
	/*este if es para que el grid no contenga mas de 30 registro esto por motivo de performance
	 * y eol navegador no se coma la memoria */
	if ($('#tablaTiempo > tbody > tr').length <= 30){
 		
		$("#tablaTiempo").prepend("<tr>" +
				"<td>"+theJSON.fecha+"</td>" +
				"<td>"+theJSON.folio+"</td>" +
				"<td>"+theJSON.ip+"</td>" +
				"<td>"+theJSON.mensaje+"</td>" +
				"</tr>");
		
		
	}else {
		
		$('#tablaTiempo tr:last').remove();
		
		
	}
 	
	
}

function pintaPuntoEnSerie(y, x, numSerie, id) {

	try{
		eval(id+'.series[numSerie].addPoint([x,y], true, true)');
		
	}catch(e){
		console.log(e);
	}
}





