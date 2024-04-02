import org.w3c.dom.Node;

public class CarLinkedList implements CarList {
    private Node first;
    private int size = 0;
    private Node last;

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }


    @Override
    public Car get(int index) {
        return null;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(car);
        } else { // !!!!!!!!!!!!!!!!!!
            Node nodeNext = getNode(index);
            Node nodePrevious = nodeNext.previous;
            Node newNode = new Node(nodePrevious, car, nodeNext);
            nodeNext.previous = newNode;
            if (nodePrevious != null) {
                nodePrevious.next = newNode;
            }else {
                first = newNode;
            }
        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        first = null;
        last = null;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodePrevious = node.previous;
        Node nodeNext = node.next;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }


        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    private Node getNode (int index) { //!!!!!!!!!!!! !!!!!!!!!!
        Node node = first;
        for (int i = 0; i < index; i++) {
           node =  node.next;
        }
       return node;
    }
}