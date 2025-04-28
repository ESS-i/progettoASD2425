package progettoASD2425;

import java.util.ArrayList;

public class AlberoVP<T>{
	private ArrayList<NodoVP<T>> nodesList;
	private ArrayList<NodoVP<T>> parentList;
	private NodoVP<T> root;
	
	public AlberoVP(NodoVP<T> root) {
		nodesList= new ArrayList<NodoVP<T>>();
		parentList= new ArrayList<NodoVP<T>>();
		this.root = root; 
	}

}
