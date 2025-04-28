package progettoASD2425;

import java.util.ArrayList;

public class NodoVP<T> {
	private T info;
	private NodoVP<T> parent;
	private ArrayList<NodoVP<T>> childList;
	private int level;
	
	
	public NodoVP(NodoVP<T> parent, T info) {
		this.info = info; 
		this.childList =  new ArrayList<NodoVP<T>>();
		this.parent=parent;
		
		
	}
	
	
	public int getLevel() {
		return level;
	}
	
	public T getInfo() {
		return info;
	}
	public NodoVP<T> getParent() {
		return parent;
	}
	private ArrayList<NodoVP<T>> getChildList() {
		return childList;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}


	@Override
	public String toString() {
		//TODO: da finire stampa stringa 
		return info+"["+"]";
	}
	
	
	
	
	
	
	
}
