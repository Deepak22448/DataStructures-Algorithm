import java.util.ArrayDeque;
import java.util.Deque;

class myStack {
    private Node top;

    myStack(){
        this.top = null;
    }

    public void push(int data){
        Node newNode = new Node(data);

        if(this.top == null){
           top = newNode;
        } else {
            newNode.next = top;
            this.top = newNode;
        }
    }

    public int pop(){
        if(top == null) return -1;

        int popElement = top.data;
        this.top = top.next;

        return popElement;
    }

    public int peek(){
        if(this.top == null) return -1;
        return this.top.data;
    }

    public void print(){
        Node temp = this.top;
        System.out.print("[");

        while(temp != null){
            System.out.print( " " + temp.data  );
            temp = temp.next;
        }

        System.out.println(" ]");
    }
    
}

public class StackStructure {
    public static void main(String[] args) {
        myStack st = new myStack();
        st.push(1);
        st.push(2);
        st.push(3);


        st.pop();
        st.print();

    }
}

class Node {
    int data ;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
