/*
 * Silvio Santoriello - (silvio.santoriello@edu.unifi.it) - 7158636
 * Edoardo Stefanacci - (edoardo.stefanacci@edu.unifi.it) - 7160537
 * 
*/

package progettoASD2425;

import java.util.ArrayList;

public class AlberoVP<T> {
	private ArrayList<NodoVP<T>> nodesList;
	private ArrayList<NodoVP<T>> parentList;
	private NodoVP<T> root;
	private int height;

	public AlberoVP(NodoVP<T> root) {
		nodesList = new ArrayList<NodoVP<T>>();
		parentList = new ArrayList<NodoVP<T>>();
		this.root = root;
		this.root.setParent(null);
	}

	public AlberoVP() {
		nodesList = new ArrayList<NodoVP<T>>();
		parentList = new ArrayList<NodoVP<T>>();
	}

	public NodoVP<T> setRootInEmptyTree(NodoVP<T> root) {
		this.root = root;
		this.root.setParent(null);
		nodesList.add(root);
		parentList.add(null);
		height = 0;
		return root;
	}

	public NodoVP<T> setRootNotEmpty(NodoVP<T> newRoot) {

		// Cambio i riferimenti al padre nella vecchia radice
		this.root.setParent(newRoot);
		this.root.setLevel(1);

		// Rimuovo il padre null nella lista dei parent e lo rimpiazzo con la nuova
		// radice, padre della vecchia
		parentList.removeFirst();
		parentList.addFirst(newRoot);

		// Metto come unico figlio della nuova radice la vecchia radice
		newRoot.addChild(root);

		// Aggiorno il puntatore al nodo radice con la nuova radice
		this.root = newRoot;
		this.root.setParent(null);

		// Aggiorno la lista dei nodi parent
		nodesList.addFirst(newRoot);
		parentList.addFirst(null);

		this.root.setLevel(0);
		height = 1;
		for (NodoVP<T> n : nodesList) {
			if (n.getParent() != null) {
				n.setLevel(n.getParent().getLevel() + 1);
			}
		}
		return root;
	}

	public NodoVP<T> getRoot() {
		return root;
	}

	public ArrayList<NodoVP<T>> getChildList(NodoVP<T> n) {
		return n.getChildList();
	}

	public NodoVP<T> getParent(NodoVP<T> n) {
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
		int maxLevel = 0;
		for (NodoVP<T> nodoVP : nodesList) {
			if (nodoVP.getLevel() > maxLevel) {
				maxLevel = nodoVP.getLevel();
			}
		}

		return maxLevel;
	}

	public void setNodeInfo(NodoVP<T> n, T info) {
		n.setInfo(info);
	}

	public void addNodeChild(NodoVP<T> parent, NodoVP<T> child) {
		parent.addChild(child);
		child.setParent(parent);
		nodesList.add(child);
		parentList.add(parent);
	}

	// visita in ampiezza
	public ArrayList<NodoVP<T>> visitaBF() {
		ArrayList<NodoVP<T>> listaVisitati = new ArrayList<NodoVP<T>>();
		listaVisitati.add(root);
		for (NodoVP<T> nodoVP : nodesList) {
			for (NodoVP<T> n : nodoVP.getChildList()) {
				listaVisitati.add(n);
			}
		}
		return listaVisitati;

	}

	// Visita in Profondità
	public ArrayList<NodoVP<T>> visitaDF() {
		ArrayList<NodoVP<T>> visited = new ArrayList<>();
		DF(root, visited);
		return visited;
	}

	private void DF(NodoVP<T> n, ArrayList<NodoVP<T>> visited) {
		visited.add(n);
		for (NodoVP<T> child : n.getChildList()) {
			DF(child, visited);
		}
	}

	@Override
	public String toString() {
		if (root == null)
			return "[]";
		return toStringHelper(root);
	}

	private String toStringHelper(NodoVP<T> n) {
		StringBuilder sb = new StringBuilder();
		sb.append(n.getInfo());

		ArrayList<NodoVP<T>> figli = n.getChildList();
		if (figli.isEmpty()) {
			sb.append("[ ]");
			return sb.toString();
		}

		sb.append("[");
		for (int i = 0; i < figli.size(); i++) {
			sb.append(toStringHelper(figli.get(i)));
			if (i < figli.size() - 1) {
				// è l'ultimo nodo
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();

	}

}
