package Program54;

public class Program {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(1);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.left.left.right = new Node(2);
		root.left.left.right.left = new Node(1);

		root.right = new Node(1);
		root.right.right = new Node(2);
		root.right.right.right = new Node(1);
		root.right.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.left.left = new Node(1);

		boolean result = isUniformPath(root);
		System.out.println(result);

	}

	public static boolean isUniformPath(Node node) {

		if (node == null)
			return true;

		if (node.left != null && node.value != node.left.value)
			return false;

		if (node.right != null && node.value != node.right.value)
			return false;

		return isUniformPath(node.left) || isUniformPath(node.right);

	}

}
