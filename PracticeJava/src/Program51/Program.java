package Program51;

public class Program {
	public static void main(String[] args) {

		Tree tree = new Tree();

		tree.addNode(8);
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(10);
		tree.addNode(4);
		tree.addNode(7);
		tree.addNode(1);
		tree.addNode(14);
		tree.addNode(13);

		Node node = tree.getRoot();

		tree.printTree(node);

	}
}
