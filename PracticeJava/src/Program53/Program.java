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
		Node parentNode = tree.getParentNode(root, 7);
		tree.printInOrder(parentNode);
		System.out.println("\n" + "simblingNode");
		Node simblingNode = tree.getSimblingNode(root, 3);
		tree.printInOrder(simblingNode);
		System.out.println("\n" + "inorderParent");
		Node inorderParent = tree.getInorderParent(root, 3);
		tree.printInOrder(inorderParent);
		int value = tree.getDifferenceOfEvenAndOdd(root);
		System.out.println("\n" + value);
		int maxValue = tree.getMax(root);
		System.out.println(maxValue);
		int maxLength = tree.getMaxLength(root);
		System.out.println(maxLength);
		int maxLength2 = tree.getMaxLength2(root);
		System.out.println(maxLength2);
		System.out.println("delete");
		Node nodeAfterDelete = tree.deleteNode(root, 6);
		tree.printInOrder(nodeAfterDelete);

		System.out.println("\n" + "end");
	}

}
