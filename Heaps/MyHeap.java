package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHeap {

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class myComparator implements Comparator<User> {
        public int compare(User o1, User o2) {
            return Integer.compare(o1.id, o2.id);
        }
    }

    static class Heap {
        int arr[] = new int[100];
        int size;

        Heap() {
            this.arr[0] = -1;
            this.size = 0;
        }

        void insert(int val) {
            int index = ++size;
            arr[index] = val;

            while (index > 1) {
                int parent = index / 2;
                if (arr[parent] < arr[index]) {
                    swap(arr, index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        void delete() {
            if (size == 0)
                System.out.println("Nothing to delete from heap");

            arr[1] = arr[size];
            size--;

            // take root node to correct position.
            int rootIndex = 1;

            while (rootIndex < size) {
                int leftChildIndex = rootIndex * 2;
                int rightChildIndex = (rootIndex * 2) + 1;

                if (leftChildIndex < size && arr[rootIndex] < arr[leftChildIndex]) {
                    swap(arr, leftChildIndex, rootIndex);
                    rootIndex = leftChildIndex;
                } else if (rightChildIndex < size && arr[rightChildIndex] < arr[rightChildIndex]) {
                    swap(arr, rightChildIndex, rootIndex);
                    rootIndex = rightChildIndex;
                } else {
                    break;
                }
            }
        }

        void print() {
            System.out.println();
            for (int i = 1; i <= size; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    private static void heapify(int arr[], int n, int i) {
        int largest = i;

        int left = 2 * i;
        int right = 2 * i + 1;

        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);

            heapify(arr, n, largest);
        }
    }

    private static void heapSort(int arr[], int n) {
        for (int idx = n - 1; idx > 0; idx--) {
            swap(arr, idx, 0);
            heapify(arr, idx, 0);
        }
    }

    public static class User {
        int id;

        User(int id) {
            this.id = id;
        }

    }

    public static void main(String[] args) {
        // Heap maxHeap = new Heap();
        // maxHeap.insert(10);

        // int arr[] = new int[] { -1, 54, 53, 55, 52, 50 };
        // int n = arr.length;

        // for (int i = n / 2; i > 0; i--)
        // heapify(arr, n, i);

        // System.out.println("----Heapify----");
        // for (int i = 1; i < n; i++)
        // System.out.print(arr[i] + " ");
        // System.out.println();

        // heapSort(arr, n);

        // System.out.println("----HeapSort----");
        // for (int i = 0; i < n - 1; i++)
        // System.out.print(arr[i] + " ");
        // System.out.println();

        PriorityQueue<User> pq = new PriorityQueue<User>(new myComparator());

        pq.add(new User(10));
        pq.add(new User(3));

        pq.forEach((user) -> System.out.println("UserId : " + user.id + " "));
    }
}
