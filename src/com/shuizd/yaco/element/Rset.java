package com.shuizd.yaco.element;

import java.util.ArrayList;
import java.util.List;

public class Rset extends Node {
	
	private List<Route> routes = new ArrayList<Route>();
	
	private Other other;

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public Other getOther() {
		return other;
	}

	public void setOther(Other other) {
		this.other = other;
	}
}
