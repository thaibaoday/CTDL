package Lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> node;

	public BST() {
		this.node = null;
	}

	// Add element e into BST
	public void add(E e) {
		node = add(node, e);
	}

	private BNode<E> add(BNode<E> node, E e) {
		if (node == null) {
			return new BNode<>(e);
		}
		int element = e.compareTo(node.data);
		if (element < 0) {
			node.left = add(node.left, e);
		} else if (element > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E e) {
		return depth(node, e, 1);
	}

	private int depth(BNode<E> node, E e, int level) {
		if (node == null) {
			return -1;
		}
		if (node.data.equals(e)) {
			return level;
		}
		int downlevel = depth(node.left, e, level + 1);
		if (downlevel != -1) {
			return downlevel;
		}
		downlevel = depth(node.right, e, level + 1);
		return downlevel;
	}

	// compute the height of BST
	public int height() {
		return height(node);
	}

	private int height(BNode<E> node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	// Compute total nodes in BST
	public int size() {
		return size(node);
	}

	private int size(BNode<E> node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		return contains(node, e);
	}

	private boolean contains(BNode<E> node, E e) {
		if (node == null) {
			return false;
		}
		int cmp = e.compareTo(node.data);
		if (cmp < 0) {
			return contains(node.left, e);
		} else if (cmp > 0) {
			return contains(node.right, e);
		} else {
			return true;
		}
	}

	// Find the minimum element in BST
	public E findMin() {
		if (node == null) {
			return null;
		}
		return findMin(node).data;
	}

	private BNode<E> findMin(BNode<E> node) {
		if (node.left == null) {
			return node;
		}
		return findMin(node.left);
	}

	// Find the maximum element in BST
	public E findMax() {
		if (node == null) {
			return null;
		}
		return findMax(node).data;
	}

	private BNode<E> findMax(BNode<E> node) {
		if (node.right == null) {
			return node;
		}
		return findMax(node.right);
	}

	// Remove element e from BST
	public boolean remove(E e) {
		int initialSize = size();
		node = remove(node, e);
		return size() != initialSize;
	}

	private BNode<E> remove(BNode<E> node, E e) {
		if (node == null) {
			return null;
		}
		int cmp = e.compareTo(node.data);
		if (cmp < 0) {
			node.left = remove(node.left, e);
		} else if (cmp > 0) {
			node.right = remove(node.right, e);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				node.data = findMin(node.right).data;
				node.right = remove(node.right, node.data);
			}
		}
		return node;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		List<E> descendants = new ArrayList<>();
		BNode<E> node = getNode(data);
		getDescendants(node, descendants);
		return descendants;
	}

	private void getDescendants(BNode<E> node, List<E> descendants) {
		if (node != null) {
			descendants.add(node.data);
			getDescendants(node.left, descendants);
			getDescendants(node.right, descendants);
		}
	}

	private BNode<E> getNode(E data) {
		BNode<E> current = node;
		while (current != null) {
			int cmp = data.compareTo(current.data);
			if (cmp < 0) {
				current = current.left;
			} else if (cmp > 0) {
				current = current.right;
			} else {
				return current;
			}
		}
		return null;
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		List<E> ancestors = new ArrayList<>();
		BNode<E> current = node;
		while (current != null) {
			int cmp = data.compareTo(current.data);
			if (cmp < 0) {
				current = current.left;
			} else if (cmp > 0) {
				ancestors.add(current.data);
				current = current.right;
			} else {
				break;
			}
		}
		return ancestors;
	}

	// display BST using inorder approach
	public void inorder() {
		inorder(node);
	}

	private void inorder(BNode<E> node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	// display BST using preorder approach
	public void preorder() {
		preorder(node);
	}

	private void preorder(BNode<E> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);

	}

	// display BST using postorder approach
	public void postorder() {
		postorder(node);
	}

	private void postorder(BNode<E> node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");

		}

	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		Integer[] arr = { 25, 4, 10, 12, 15, 18, 22, 24, 31, 35, 44, 50, 66, 70, 90 };
		bst.add(Arrays.asList(arr));

		// Test size
		System.out.println("Size: " + bst.size());

		// Test contains
		System.out.println("Contains 22: " + bst.contains(22));
		System.out.println("Contains 13: " + bst.contains(13));

		// Test findMin and findMax
		System.out.println("Min: " + bst.findMin());
		System.out.println("Max: " + bst.findMax());

		// Test depth
		System.out.println("Depth of 24: " + bst.depth(24));
		System.out.println("Depth of 50: " + bst.depth(50));

		// Test height
		System.out.println("Height: " + bst.height());

		// Test remove
		System.out.println("Remove 12: " + bst.remove(12));
		System.out.println("Size after removing 12: " + bst.size());

		// Test descendants
		System.out.println("Descendants of 22: " + bst.descendants(22));

		// Test ancestors
		System.out.println("Ancestors of 22: " + bst.ancestors(22));

		System.out.println("Inorder traversal of the given tree");
		bst.inorder();

		System.out.println("\nPreorder traversal of the given tree");
		bst.preorder();

		System.out.println("\nPostorder traversal of the given tree");
		bst.postorder();
	}

}
