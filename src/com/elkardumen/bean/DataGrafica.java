package com.elkardumen.bean;

public class DataGrafica {
	
	String name;
	String type;
	String color;
	FillColor fillColor;
	long pointInterval;
	long pointStart;
	boolean showInLegend;
	Object data;
	int yAxis;
	
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public FillColor getFillColor() {
		return fillColor;
	}
	public void setFillColor(FillColor fillColor) {
		this.fillColor = fillColor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getPointInterval() {
		return pointInterval;
	}
	public void setPointInterval(long pointInterval) {
		this.pointInterval = pointInterval;
	}
	public long getPointStart() {
		return pointStart;
	}
	public void setPointStart(long pointStart) {
		this.pointStart = pointStart;
	}
	public boolean isShowInLegend() {
		return showInLegend;
	}
	public void setShowInLegend(boolean showInLegend) {
		this.showInLegend = showInLegend;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	
	
}
