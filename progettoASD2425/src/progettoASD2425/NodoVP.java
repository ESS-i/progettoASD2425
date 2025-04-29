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

	public void addChild(NodoVP<T> child, T info) {
		// TODO osserva che il costruttore già accetta info come parametro, fixare.
		child.setInfo(info);
		child.setLevel(this.getLevel() + 1);
		this.childList.add(child);
	}

	public void addChild(NodoVP<T> child) {
		child.setInfo(child.getInfo());
		child.setLevel(this.getLevel() + 1);
		this.childList.add(child);

	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLeaves() {
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
