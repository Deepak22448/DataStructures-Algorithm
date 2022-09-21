package LinkList;

public class Dll {
    Node head;
    int size;

    Dll() {
        this.head = null;
        this.size = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        this.size++;
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        newNode.next = this.head;
        head.prev = newNode;
        this.head = newNode;

    }

    public void insertAfter(int index, int data) {
        if (index >= this.size || index < 0) {
            System.out.println("Invalid index " + index + " for insert.");
            return;
        }
        if (index == this.size - 1) {
            append(data);
            return;
        }

        this.size++;
        Node newNode = new Node(data);

        Node current = this.head;
        while (index > 0) {
            current = current.next;
            index--;
        }

        Node temp = current.next;
        current.next = newNode;

        newNode.next = temp;
        temp.prev = newNode;

        newNode.prev = current;

    }

    public void insertBefore(int index, int data) {

        if (index >= this.size || index < 0) {
            System.out.println("Invalid index " + index + " for insert.");
            return;
        }

        if (index == 0) {
            push(data);
            return;
        }

        Node newNode = new Node(data);
        this.size++;

        Node current = this.head;
        while (index > 0) {
            current = current.next;
            index--;
        }

        Node temp = current.prev;
        current.prev = newNode;

        newNode.next = current;
        newNode.prev = temp;
        temp.next = newNode;

    }

    public void append(int data) {
        this.size++;

        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    public void deleteAt(int index) {
        if (index >= this.size || index < 0) {
            System.out.println("Invalid index " + index + " for delete.");
            return;
        }

        Node current = this.head;
        if (index == this.size - 1) {
            deleteEnd();
            return;
        }

        if (index == 0) {
            deleteStart();
            return;
        }

        this.size--;

        while (index > 0) {
            current = current.next;
            index--;
        }

        Node prev = current.prev;
        Node next = current.next;

        prev.next = next;
        next.prev = prev;

    }

    private void deleteEnd() {
        this.size--;
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
    }

    private void deleteStart() {
        this.size--;
        this.head = this.head.next;
        this.head.prev = null;
    }

    public void debug() {
        Node current = this.head;

        System.out.println("-----DEBUG Start------");

        while (current != null) {

            if (current.prev != null)
                System.out.print(" Prev " + current.prev.data + " ");
            else
                System.out.print(" No Prev ");

            System.out.print(" Data " + current.data + " ");

            if (current.next != null)
                System.out.print(" Next " + current.next.data + " ");
            else
                System.out.print(" No Next ");

            current = current.next;

            System.out.println();
        }

        System.out.println("-----DEBUG End------");

    }

    public void print() {
        Node current = this.head;

        System.out.print("[ ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        Dll dll = new Dll();
        dll.push(10);
        dll.append(9);
        dll.insertAfter(1, 8);
        dll.append(7);
        dll.insertBefore(0, 11);
        dll.deleteAt(0);
        dll.debug();

        dll.print();
    }

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }
}
