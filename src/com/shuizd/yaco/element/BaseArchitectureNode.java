package com.shuizd.yaco.element;

import java.util.ArrayList;
import java.util.List;

public class BaseArchitectureNode extends Node {

	private List<FieldObj> fieldObjs = new ArrayList<FieldObj>();
	
	private List<Fset> fsets = new ArrayList<Fset>();
	
	private List<Loop> loops = new ArrayList<Loop>();
	
	private List<Rset> rsets = new ArrayList<Rset>();
	
	public List<FieldObj> getFields() {
		return fieldObjs;
	}
	public void setFields(List<FieldObj> fieldObjs) {
		this.fieldObjs = fieldObjs;
	}
	public List<Fset> getFsets() {
		return fsets;
	}
	public void setFsets(List<Fset> fsets) {
		this.fsets = fsets;
	}
	public List<Loop> getLoops() {
		return loops;
	}
	public void setLoops(List<Loop> loops) {
		this.loops = loops;
	}
	public List<Rset> getRsets() {
		return rsets;
	}
	public void setRsets(List<Rset> rsets) {
		this.rsets = rsets;
	}
}
