/*
 * Silvio Santoriello - (silvio.santoriello@edu.unifi.it) - 7158636
 * Edoardo Stefanacci - (edoardo.stefanacci@edu.unifi.it) - 7160537
 * 
*/

package progettoASD2425;

import java.util.ArrayList;

public class NodoVP<T> {
	private T info;
	private NodoVP<T> parent;
	private ArrayList<NodoVP<T>> childList;
	private int level;

	public NodoVP(T info) {
		this.info = info;
		this.childList = new ArrayList<NodoVP<T>>();
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

	public ArrayList<NodoVP<T>> getChildList() {
		return childList;
	}

	public int getChildListSize() {
		return getChildList().size();
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setParent(NodoVP<T> parent) {
		this.parent = parent;
	}

	public void addChild(NodoVP<T> child) {
		child.setLevel(this.getLevel() + 1);
		this.childList.add(child);

	}

	@Deprecated
	public void addChild(NodoVP<T> child, T info) {
		// Nota: tale metodo, in overload con quello sopra
		// permette di sovrascrivere l'informazione nel nodo figlio, ma nella nostra
		// implementazione
		// non lo usiamo mai
		child.setInfo(info);
		child.setLevel(this.getLevel() + 1);
		this.childList.add(child);
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLeavesSize() {
		// abbiamo inteso "resitutire il numero delle foglie di un nodo" come
		// "restituire il numero di figli che a loro volta non hanno figli"

		int leavesCounter = 0;
		for (NodoVP<T> nodoVP : childList) {
			if (nodoVP.getChildList().isEmpty())
				leavesCounter++;
		}
		return leavesCounter;
	}

	@Override
	public String toString() {
		return info.toString();
	}

}
