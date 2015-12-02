<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Ejemplos Kardumen</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>



<body onload="dwr.engine.setActiveReverseAjax(true);dwr.engine.setErrorHandler(errh);">
  <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="http://elkardumen.blogspot.com/" class="brand-logo">Kardumen</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="#">Spring + DWR + materializecss</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Spring + DWR + materializecss</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>


<div class="container">
  
	<div class="row">
		<div class="col s12 m6 l6"> <!-- Note that "m4 l3" was added -->
	        <div id="Area" >
					<img src="images/ajax_loader.gif" height="25" width="25" style="margin: 20px">
			</div>
	
	    </div>
	
	    <div class="col s12 m6 l6"> <!-- Note that "m8 l9" was added -->
	        <div id="Linear">
					<img src="images/ajax_loader.gif" height="25" width="25"  style="margin: 20px"	>
			</div>
		</div>
	 	<div class="col s12"> <!-- Note that "m8 l9" was added -->
	    	<div style="overflow: auto;  height: 400px">
	    	<table id="tablaTiempo" class="striped">
				<thead>
		        	<tr>
		            	<th data-field="fecha">Fecha</th>
		                <th data-field="folio">Folio</th>
		                <th data-field="ip">Ip</th>
		                <th data-field="mensaje">Mensaje</th>
		             </tr>
		        </thead>
		        <tbody>
		                
		        </tbody>
		    </table>
	    	</div>
		</div>
    </div>
</div>          



  <footer class="page-footer light-blue">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">elKardumen.blogspot.mx</h5>
          <p class="grey-text text-lighten-4">Ejemplo DWR con Spring</p>


        </div>
       
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="orange-text text-lighten-3" href="http://elKardumen.blogspot.mx">@xola139</a>
      </div>
    </div>
  </footer>


<!-- Librerias para Graficar --> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jsHighStocks/highstock.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/colores.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dibujaGraficas.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/custom-functions.js" ></script>

<!--scripts DWR --> 
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/cargaGrafica.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>


<!--  Scripts-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/materialize.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/init.js"></script>

  </body>
</html>



