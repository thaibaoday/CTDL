package Lab11;

public class BNode<E extends Comparable<E>> {
    E data;
    BNode<E> left;
    BNode<E> right;

    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BNode(E data, BNode<E> left, BNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}