package progettoASD2425;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.ArrayList;
import java.util.Collections;

public class AlberoVP<T>{
	private ArrayList<NodoVP<T>> nodesList;
	private ArrayList<NodoVP<T>> parentList;
	private NodoVP<T> root;
	private int height;
	
	public AlberoVP(NodoVP<T> root) {
		nodesList= new ArrayList<NodoVP<T>>();
		parentList= new ArrayList<NodoVP<T>>();
		this.root = root;
		this.root.setParent(null);
	}
	
	public AlberoVP() {
		nodesList= new ArrayList<NodoVP<T>>();
		parentList= new ArrayList<NodoVP<T>>();
	}
	
	public NodoVP<T> setRootInEmptyTree(NodoVP<T> root){
		this.root = root;
		this.root.setParent(null);
		height = 0;
		return root;
	}
	
	public NodoVP<T> setRootNotEmpty(NodoVP<T> newRoot){
		this.root.setParent(newRoot);
		this.root.setLevel(1);
		this.root = newRoot;
		this.root.setParent(null);
		this.root.setLevel(0);
		height = 1;
		for (NodoVP<T> n : nodesList) {
			if(!n.getParent().equals(null)) {
				n.setLevel(n.getParent().getLevel() + 1);
			}
		}
		return root;
	}

	public NodoVP<T> getRoot(){
		return root;
	}
	
	public ArrayList<NodoVP<T>> getChildList(NodoVP<T> n){
		return n.getChildList();
	}
	
	public NodoVP<T> getParent(NodoVP<T> n){
		return n.getParent();
	}
	
	public int getNodesSize() {
		return nodesList.size();
	}
	
	public int getChildListSize(NodoVP<T> n) {
		return getChildList(n).size();
	}
	
	public T getNodeInfo(NodoVP<T> n) {
		return n.getInfo();
	}
	
	public int getHeight() {
		int maxLevel=0;
		for (NodoVP<T> nodoVP : nodesList) {
			if (nodoVP.getLevel()>maxLevel) {
				maxLevel=nodoVP.getLevel();
			}
		}
		
		return maxLevel;
		//return Collections.max(nodesList, (s1,s2)->(s1.getLevel()-s2.getLevel()); TODO: vedere se funziona
	}
	
	public void setNodeInfo(NodoVP<T> n , T info) {
		n.setInfo(info);
	}
	
	//visita in ampiezza
	public ArrayList<NodoVP<T>> visitaBF(){
		ArrayList<NodoVP<T>> listaVisitati=new ArrayList<NodoVP<T>>();
		for (NodoVP<T> nodoVP : nodesList) {
			for (NodoVP<T> n : nodoVP.getChildList()) {
				listaVisitati.add(n);
			}
		}
		return listaVisitati;
		
	}
		
	
	
	
	
}
