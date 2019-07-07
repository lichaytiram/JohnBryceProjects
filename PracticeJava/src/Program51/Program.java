package Program51;

public class Program {
	public static void main(String[] args) {

		Tree tree = new Tree();
		
		tree.addNode(2);
		tree.addNode(3);
		tree.addNode(4);
		
		Node node = tree.getRoot();
		
		tree.printTree(node);
		
	}
}
