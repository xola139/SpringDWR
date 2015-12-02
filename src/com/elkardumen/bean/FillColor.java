package com.elkardumen.bean;

import java.util.List;

public class FillColor{
	
	LinearGradient linearGradient;
	List<Object> stops;
	
	public List<Object> getStops() {
		return stops;
	}

	public void setStops(List<Object> stops) {
		this.stops = stops;
	}

	public LinearGradient getLinearGradient() {
		return linearGradient;
	}

	public void setLinearGradient(LinearGradient linearGradient) {
		this.linearGradient = linearGradient;
	}
	

}


