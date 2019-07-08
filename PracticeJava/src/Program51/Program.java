package Program51;

public class Program {
	public static void main(String[] args) {

		Tree tree = new Tree();

		tree.addNode(2);
		tree.addNode(3);
		tree.addNode(4);
		tree.addNode(4);
		tree.addNode(5);
		tree.addNode(4);
		tree.addNode(8);

		Node node = tree.getRoot();

		tree.printTree(node);

	}
}
