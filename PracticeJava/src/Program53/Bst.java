package Program53;

public class Bst {

	public void printInOrder(Node node) {

		if (node != null) {

			printInOrder(node.getLeft());
			System.out.print(node.getValue() + " ");
			printInOrder(node.getRight());

		}

	}

	public void printPreOrder(Node node) {

		if (node != null) {

			System.out.print(node.getValue() + " ");
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());

		}

	}

	public void printPostOrder(Node node) {

		if (node != null) {

			printPostOrder(node.getLeft());
			printPostOrder(node.getRight());
			System.out.print(node.getValue() + " ");

		}

	}

	public boolean isNodeExist(Node node, int value) {

		if (node == null)
			return false;

		if (node.getValue() == value)
			return true;

		return isNodeExist(node.getLeft(), value) || isNodeExist(node.getRight(), value);

	}

	public Node insert(Node node, int value) {

		if (node == null)
			return new Node(value);

		if (value < node.getValue())
			node.setLeft(insert(node.getLeft(), value));

		else
			node.setRight(insert(node.getRight(), value));

		return node;
	}

}
