package LinkList;

public class LinkList {
    Node head;
    int size;

    LinkList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        this.size++;

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        Node temp = this.head;
        newNode.next = temp;
        this.head = newNode;

    }

    public void insertAt(int index, int data) {
        if (index > this.size || index < 0) {
            System.out.println("----Invalid index " + index + " to insert-----");
            return;
        }
        if (index == 0) {
            insertAtHead(data);
            return;
        }
        if (index == this.size) {
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        while (index > 1) {
            current = current.next;
            index--;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;

        this.size++;

    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0) {
            System.out.println("Invalid index " + index + " to delete");
            return;
        }

        this.size--;

        if (index == 0) {
            System.out.println("Deleted " + this.head.data);
            this.head = this.head.next;
            return;
        }

        Node current = head;
        while (index > 1) {
            current = current.next;
            index--;
        }

        System.out.println("Deleted " + current.next.data);
        current.next = current.next.next;
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
        LinkList list = new LinkList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);

        list.insertAtHead(100);
        list.insertAtHead(101);

        list.insertAt(0, 99);
        list.insertAt(1, 199);
        list.insertAt(list.size, 299);

        list.deleteAtIndex(1);
        list.deleteAtIndex(0);
        list.deleteAtIndex(list.size - 1);
        list.insertAtHead(99);

        list.print();
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
