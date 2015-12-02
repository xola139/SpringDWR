var merge = Highcharts.merge;
var perShapeGradient = {
            x1: 0,
            y1: 0,
            x2: 1,
            y2: 1
        };

var availableChartColors = [ {
	linearGradient : [ 0, 0, 0, 400 ],
	stops : [ [ 0, 'rgba(81, 252, 65, .8)' ], [ 1, 'rgba(0, 0, 0, 0)' ] ]
}, {
	linearGradient :  merge(perShapeGradient),
	stops : [ [ 0, 'rgb(6, 109, 171)' ], [ 1, 'rgba(197, 222, 234)' ] ]
},{
	linearGradient :  merge(perShapeGradient),
	stops : [ [ 0,	'rgb(242,242,242)' ], [ 1,  'rgb(249,205,92)' ] ]//amarillo
},{
	linearGradient :  merge(perShapeGradient),
	stops : [ [ 0,	'rgb(156,191,226)' ], [ 1, 'rgb(107,168, 229)'  ] ]//azul
}, {
	linearGradient : [ 0, 0, 0, 400 ],
	stops : [ [ 0, 'rgb(244, 25, 10)' ], [ 1, 'rgba(0, 0, 0, 0)' ] ]
} ];


var vcolors = Highcharts.getOptions().colors;
vcolors = [
     {
    	 linearGradient: merge(perShapeGradient),
    	 stops: [[0, 'rgb(247,177,0)'], [1, 'rgb(242,242,242)']],//1.-Amarillo
     },
     {
    	
     	linearGradient: merge(perShapeGradient),
         stops: [[0, 'rgb(248,80,50)'], [1, 'rgb(241,111,92)']],//2.-Naranja
      },
     {	
     	linearGradient: merge(perShapeGradient),
         stops: [[0, 'rgb(249,205,92)'],[1, 'rgb(242,242,242)']],//3.-Amarillo
      },
      {
     	
      	linearGradient: merge(perShapeGradient),
          stops: [[0, 'rgb(107,168, 229)'],[1, 'rgb(156,191,226)']],//4.-Azul
       },
       {      
           linearGradient: merge(perShapeGradient),
       stops: [[0, 'rgb(235,233,249)'],[1, 'rgb(140,142,216)']],//5.-morado
    
       },
       {
      	 linearGradient: merge(perShapeGradient),
      	 stops: [[0, 'rgb(6, 255, 255)'],[1, 'rgb(0,110,110)']],//6.-turquesa
       },
       {
      	 linearGradient: merge(perShapeGradient),
      	 stops: [[0, 'rgb(255, 240, 198)'],[1, 'rgb(247,182,4)']],//7.-Amarillo claro	
       },
       {
      	 linearGradient: merge(perShapeGradient),
      	 stops: [[0, 'rgb(180, 221, 180)'],[1, 'rgb(0,87,0)']],//8.-verde
       },
       
       
       
 ];



var Ecolors = Highcharts.getOptions().colors;
Ecolors = [
    
       {
        	 linearGradient: merge(perShapeGradient),
        	 stops: [[0, 'rgb(107,168, 229)'],[1, 'rgb(156,191,226)']],
         },{
      	 linearGradient: merge(perShapeGradient),
      	 stops: [[0, 'rgb(6, 255, 255)'],[1, 'rgb(0,110,110)']],
      	 
       }
       
 ];

var TwoColors = Highcharts.getOptions().colors;
TwoColors = [
    
           {
            	
             	linearGradient: merge(perShapeGradient),
                 stops: [[0, 'rgb(248,80,50)'], [1, 'rgb(241,111,92)'] ],//4.-
              },
              {      
                  linearGradient: merge(perShapeGradient),
              	 stops: [ [0, 'rgb(156,191,226)'],[1, 'rgb(107,168, 229)']],//6.-
           
              }
       
 ];


var simpleColor = Highcharts.getOptions().colors;
simpleColor = ['#f1da36','#cc0000','#61c419'];



/***************************/


