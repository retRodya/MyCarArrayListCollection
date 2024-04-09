import org.w3c.dom.Node;

public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size;

    static class Node {
        Node previous;
        Car value;
        Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            last = new Node(null, car, null);
            first = last;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;

        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        Node node = getNode(index);
        if (node.previous != null) {
            Node previous = node.previous;

            if (node.next != null) {
                Node next = node.next;

                node = new Node(previous, car, next);
                previous.next = next.previous = node;
            }
        } else {

        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                removeAt(i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        if (index >= 0 && index < size) {
            Node node = getNode(index);
            Node previous = node.previous;
            Node next = node.next;

            previous.next = next;
            next.previous = previous;

            node.previous = node.next = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}