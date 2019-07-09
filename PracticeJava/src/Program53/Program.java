package Program53;

public class Program {

	public static void main(String[] args) {

		Bst tree = new Bst();
		Node root = null;

		root = tree.insert(root, 8);
		root = tree.insert(root, 3);
		root = tree.insert(root, 6);
		root = tree.insert(root, 10);
		root = tree.insert(root, 4);
		root = tree.insert(root, 7);
		root = tree.insert(root, 1);
		root = tree.insert(root, 14);
		root = tree.insert(root, 13);

		tree.printInOrder(root);
		System.out.println();
		tree.printPreOrder(root);
		System.out.println();
		tree.printPostOrder(root);
		System.out.println();
		System.out.println(tree.isNodeExist(root, 8));

		System.out.println("\n" + "end");
	}

}
