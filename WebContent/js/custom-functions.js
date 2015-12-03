jQuery(document).ready(function(){
	
	//Traemos los valores iniciales de la grafica
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
		var x;
		var y;
		
		x = theJSON.valores[0].x;
		y = [ theJSON.valores[0].y,theJSON.valores[1].y,theJSON.valores[2].y]
		
		/*Puntos Grafica Linear*/
		pintaPuntoEnSerie(y,x,"Linear");
		
		/*Puntos grafica area*/
		pintaPuntoEnSerie(y,x,"Area");
		
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

function pintaPuntoEnSerie(y, x, id) {

	try{
		if(id=="Area"){
			Area.series[0].addPoint([x,y[0]], false, false);
			Area.series[1].addPoint([x,y[1]], true, false);
		}else{
			Linear.series[0].addPoint([x,y[0]], false, false);
			Linear.series[1].addPoint([x,y[1]], false, false);
			Linear.series[2].addPoint([x,y[2]], true, false);
		}
	}catch(e){
		console.log(e);
	}
}

