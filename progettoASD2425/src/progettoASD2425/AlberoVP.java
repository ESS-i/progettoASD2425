package progettoASD2425;

import java.util.ArrayList;

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
}
