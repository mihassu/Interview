package lesson03;

public class Node<E> {

    public E value;
    public Node<E> next;
    public Node<E> prev;


    public Node() {
    }

    public Node(E value) {
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void add(E value) {
        if (hasNext()) {
            next.add(value);
        } else {
            Node newNode = new Node(value);
            newNode.prev = this;
            next = newNode;
        }
    }
}
