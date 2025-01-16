public class ProtoLinkedList<T> {
    private class Node {
        T data;
        Node next;
        Node previous;

        Node(T data) {
            this.data = data;
        }
    }
//    private Node findNode(int index) {
//        Node current = head;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//        return current;
//    }


    private int size;
    private Node head;
    private Node tail;


    public ProtoLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public void add(T addition) {
        Node newNode = new Node(addition);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }
    public void outOfBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }


    public T get(int index) {
        outOfBounds(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data; //getNode(index).data;
    }
    public int size(){
        return size;
    }

    public T remove(int index) {
        outOfBounds(index);
        Node current;
        if(index == 0) {
            current = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = tail.previous;
            tail.next = null;
        } else {
//            Node current = findNode(index);
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        } size--;
        return current.data;
    }

    @Override
    public String toString(){
        if(head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while(current.next != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data).append("]");
        return sb.toString();
    }

}
