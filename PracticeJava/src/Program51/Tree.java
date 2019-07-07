package Program51;

public class Tree {

	private Node root;
	private Node newNode;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getNewNode() {
		return newNode;
	}

	public void setNewNode(Node newNode) {
		this.newNode = newNode;
	}

	public void printTree(Node node) {

		if (node != null) {
			printTree(node.getLeft());
			System.out.print(node.getValue() + " ");
			printTree(node.getRight());
		}

	}

	public void addNode(int value) {

		this.newNode = new Node(value);

		if (root == null)
			this.root = newNode;

		else {

			Node focus = this.root;
			Node dad = null;

			while (true) {

				dad = focus;

				if (this.newNode.getValue() >= focus.getValue()) {

					focus = focus.getRight();
					if (focus == null) {
						dad.setRight(newNode);
						return;
					}

				} else {
					this.root = this.root.getLeft();
					if (this.getRoot() == null) {
						this.getRoot().setLeft(newNode);
						return;
					}
				}
			}
		}

	}

}
