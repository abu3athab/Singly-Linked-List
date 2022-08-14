public class SLL {
    private Node head;
    private Node tail;
    private int size;

    public SLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int getSize() {
        return this.size;
    }

    public void addToHead(Object newItem) {
        Node node = new Node(newItem);
        if (isEmpty())
            head = tail = node;
        else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addToTail(Object newItem) {
        Node node = new Node(newItem);
        if (isEmpty())
            this.head = this.tail = node;
        else {
            this.tail.next = node;
            this.tail = node;

        }
        this.size++;
    }

    public Object getHead() {
        return this.head.data;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("list is empty");
        } else {
            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("END");
        }
    }

    public Object[] reverseList() {//using array,O(n), number of operations: n+n/2
        Object[] arr = new Object[this.size];
        int i = 0;
        for (Node temp = this.head; temp != null; temp = temp.next) {
            arr[i++] = temp.data;
        }
        for (int j = 0; j < size / 2; j++) {
            Object temp = arr[j];
            arr[j] = arr[size - 1 - j];
            arr[size - 1 - j] = temp;
        }
        return arr;
    }

    private SLL optimizedReverseList() {//using linked list, O(n), number of operations: n;
        SLL list = new SLL();

        for (Node temp = this.head; temp != null; temp = temp.next) {
            list.addToHead(temp.data);
        }

        return list;
    }

    public Object getTail() {
        return this.tail.data;
    }

    public void printReversedList() {

        SLL list = optimizedReverseList();

        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " -> ");
        }

        System.out.println("END");
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
}
