$(function () {
  
  
  var options = {
        chart: {
            type: 'area',
            width:270,
			height:170,
            renderTo : 'Area'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
       
        yAxis: {
            title: {
                text: ''
            },
            labels: {
                formatter: function () {
                    return this.value / 1000 + 'k';
                }
            }
        },
    	xAxis: {/*correspinde a etiquetas debajo de graficas*/
	      lineColor: '#6e6e6e',
	      type :'datetime',
         tickInterval:60000,
	/*	      tickInterval : 240000 * 60 *1,*/
	     /* tickPixelInterval: 100,*/
	      	dateTimeLabelFormats: {
	      		day:'%H:%M'
	      	},
	      	
			labels: {
	          style: {
	          	fontSize: '9px',
	          	color: '#000',
	          	fontFamily: 'Gill Sans'
				},	
	          enabled: true
	      }, 
			
		},
        tooltip: {
            pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
        },credits:{
			enabled:false
	    },
        plotOptions: {
            area: {
                //pointStart: 1940,
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                    states: {
                        hover: {
                            enabled: true
                        }
                    }
                }
            }
        },
        series: [{
            name: 'Tiempo1',
            data: []
        }, {
            name: 'Tiempo2',
            data: []
        }]
    };
  
  eval('Area= new Highcharts.Chart(options)');
  
  
  
  
});






function getCargaInicialGraficaLinearCallBack(data){
	
	//console.log("Linear"+data);
	
	inicializaGragicaLinear('Linear', data);
	
}






function inicializaGragicaLinear(id,datos){
	
	
	
	str = jQuery.parseJSON(datos);
	
	
	
	var options ={
			chart :{
				backgroundColor: false,
				marginTop: 0,
				renderTo: id,
				borderRadius: 0,
				zoomType: 'x',
				width:270,
				height:170,
				
			},xAxis: {/*correspinde a etiquetas debajo de graficas*/
			      lineColor: '#6e6e6e',
			      type :'datetime',
		         tickInterval:60000,
			/*	      tickInterval : 240000 * 60 *1,*/
			     /* tickPixelInterval: 100,*/
			      	dateTimeLabelFormats: {
			      		day:'%H:%M'
			      	},
			      	
					labels: {
			          style: {
			          	fontSize: '9px',
			          	color: '#000',
			          	fontFamily: 'Gill Sans'
						},	
			          enabled: true
			      }, 
					
				},
	        yAxis: {
	        	min: 0,
	            title: {
	            	enabled: false,
	                text: 'Temperature (°C)'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	        	valueDecimals : 0,
	    		pointFormat: '<span style="color: {series.color}">{series.name}</span>: <b>{point.y}</b><br/>',
	            shared: true,
	            borderWidth: 1,
	            style: {
	          		color:'#FFF',
	          		fontSize: '14px',
	        		fontFamily: 'Gill Sans'    			
	          		
	          	},
	          	backgroundColor: 'rgba(10,10,10, 0.6)',
	        },
	        rangeSelector: {
	    		
	   		 buttonTheme: {
	   		 align: 'right',
	          fill: {
	             linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	             fillWidth: 0,
	             stops: [
	                [0.4, '#373737'],
	                [0.6, '#141414']
	             ]
	          },
	          stroke: false,
	          style: {
	             color: '#FFFFFF',
	             fontSize: '10px',
	             fontFamily: 'Gill Sans'
	          },
	          states: {
	             hover: {
	                fill: {
	                   linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                   stops: [
	                      [0.4, '#888'],
	                      [0.6, '#555']
	                   ]
	                },
	                stroke: false,
	                style: {
	                   color: '#FFFFFF',
	                       fontSize: '10px',
	                       fontFamily: 'Gill Sans'
	                }
	             },
	             select: {
	                fill: {
	                   linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                   stops: [	[0.1, '#464646'],
	                           	[0.3, '#1E1E1E']
	                   	   ]
	                },
	                stroke: false,
	                style: {
	                    color: '#FFFFFF',
	                    fontSize: '10px',
	        			  fontFamily: 'Gill Sans'
	                }
	             }
	          }
	       },
	   		buttons: [{ count:'1', type:'minute', text:'1m' }, 
	   		          { count:'2',  type: 'minute',  text: '2m' }, 
	   		          { type:'all', text: 'All'}
	   		         ],
	   		inputEnabled: false,
	   		selected: 2,
	   		labelStyle: {
	   				fontSize: '6px',
	   				color: '#FFFFFF',
	   				fontFamily: 'Lucida Sans Unicode, Lucida Grande'
	   			}
	   	},
	   	/*Fin range selector*/
	   	navigator: {
			maskFill: 'rgba(10, 10, 10, 0.7)',
	    	series: {
				type: "area",
	        	color: "#6E6E6E",
	        	fillColor:{
	        	 linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	             stops: [
	                [0, '#5F5F5F'],
	                [1, '#5F5F5F']
	             ]
	          },
	            lineColor: "#6E6E6E"
	        },
		      
			xAxis: {
				tickWidth: 0,
				lineWidth: 0,
				startOnTick: false,
				endOnTick: false,
				gridLineWidth: 0,
				/*type :'datetime',
		      	tickInterval : 240000 * 60 *1,*/
				tickPixelInterval: 1000,
		      	dateTimeLabelFormats: {
		      		day:'%H:%M'
		      	},
				labels: {
					style: {
	    				fontSize: '8px',
	    				color: '#FFFFFF',
	    				fontFamily: 'Lucida Sans Unicode, Lucida Grande'
					},	
					y: 8,
					x: -10
					
				}
			},
			
	    	height: 23,
	    	margin: 0,
	    	marker: {
				enabled: false
			},
			shadow: false,
			
	    	handles: {
	    		backgroundColor: 'RGB(130,130,130)'
	    	}
		},
		/*Fin navigator*/
		scrollbar: {
			enabled: false,
			trackBackgroundColor: {
		         linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
		         stops: [
		            [0, '#000'],
		            [1, '#333']
		         ]
		      },
		      trackBorderColor: '#666'
		},
		credits:{
			enabled:false
	    },	
	    exporting: {
			enabled: false
	    },
	   	
	    legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        colors:simpleColor,
	        series:str
	        
	    }
	
	eval(id+ '= new Highcharts.Chart(options)');
}