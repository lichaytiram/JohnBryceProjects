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

	public Node getParentNode(Node node, int value) {

		if (node == null)
			return null;

		Node parentNode = null;

		while (node != null) {

			if (node.getValue() > value) {
				parentNode = node;
				node = node.getLeft();
			} else if (node.getValue() < value) {
				parentNode = node;
				node = node.getRight();
			} else
				break;

		}

		return parentNode;

	}

	public Node getSimblingNode(Node node, int value) {

		if (node == null)
			return null;

		Node simblingNode = null;

		while (node != null) {

			if (value < node.getValue()) {
				simblingNode = node.getRight();
				node = node.getLeft();
			} else if (value > node.getValue()) {
				simblingNode = node.getLeft();
				node = node.getRight();
			} else
				break;

		}

		return simblingNode;

	}

	public Node getInorderParent(Node node, int value) {

		if (node == null)
			return null;

		Node inorderParent = null;

		while (node != null) {

			if (value < node.getValue()) {

				inorderParent = node;
				node = node.getLeft();

			} else if (value > node.getValue()) {

				node = node.getRight();

			} else
				break;

		}

		return inorderParent;

	}

	public int getDifferenceOfEvenAndOdd(Node node) {

		if (node == null)
			return 0;

		return node.getValue() - getDifferenceOfEvenAndOdd(node.getLeft()) - getDifferenceOfEvenAndOdd(node.getRight());
	}

	public int getMax(Node node) {

		if (node == null)
			return -1;

		if (node.getRight() == null)
			return node.getValue();

		return getMax(node.getRight());

	}

	public int getMaxLength(Node node) {

		if (node == null)
			return 0;

		int n1 = getMaxLength(node.getLeft());
		int n2 = getMaxLength(node.getRight());

		if (n1 > n2)
			return n1 + 1;

		return n2 + 1;

	}

	public int getMaxLength2(Node node) {

		if (node == null)
			return 0;

		return 1 + Math.max(getMaxLength(node.getLeft()), getMaxLength(node.getRight()));
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

	public Node deleteNode(Node node, int value) {

		if (node == null)
			return null;

		if (node.getValue() == value)
			return null;

		if (value < node.getValue())
			node.setLeft(deleteNode(node.getLeft(), value));

		else
			node.setRight(deleteNode(node.getRight(), value));

		return node;

	}

}
