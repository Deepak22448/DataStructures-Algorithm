import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();

        dq.offer(1);
        dq.add(2);
        dq.addFirst(3);
        dq.offerLast(10);
        System.out.println(dq.pollLast());
    }
}
