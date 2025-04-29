package progettoASD2425;

public class Runner {
	
	public static void main(String[] args) {
		
		AlberoVP<String> tree = new AlberoVP<String>();
		
		NodoVP<String> claudia = new NodoVP<String>("Claudia");
		tree.setRootInEmptyTree(claudia);
		
		NodoVP<String> marco = new NodoVP<String>("Marco");
		tree.addNodeChild(claudia, marco);
		NodoVP<String> luca = new NodoVP<String>("Luca");
		tree.addNodeChild(claudia,luca);
		NodoVP<String> giulia = new NodoVP<String>("Giulia");
		tree.addNodeChild(claudia,giulia);
		NodoVP<String> silvia = new NodoVP<String>("Silvia");
		tree.addNodeChild(marco, silvia);
		NodoVP<String> ugo = new NodoVP<String>("Ugo");
		tree.addNodeChild(marco, ugo);
		NodoVP<String> andrea = new NodoVP<String>("Andrea");
		tree.addNodeChild(giulia, andrea);
		NodoVP<String> gianna = new NodoVP<String>("Gianna");
		tree.addNodeChild(giulia, gianna);
		NodoVP<String> carlo = new NodoVP<String>("Carlo");
		tree.addNodeChild(andrea, carlo);
		
		NodoVP<String> antonio = new NodoVP<String>("ANTONIO");
		
		System.out.println(tree);
		System.out.println(tree.visitaBF());
		System.out.println(tree.visitaDF());
		System.out.println(tree.getHeight());
		
		tree.setRootNotEmpty(antonio);
		System.out.println(tree);
		System.out.println(tree.getRoot());
		System.out.println(tree.getChildList(giulia));
		
		System.out.println(tree.getParent(giulia));
		System.out.println(tree.getParent(claudia));
		
		System.out.println(tree.getNodesSize());
		System.out.println(antonio.getChildList());
		System.out.println(claudia.getChildListSize());
		claudia.setInfo("ANTONELLA");
		System.out.println(tree);

		
		
		
	}
}
