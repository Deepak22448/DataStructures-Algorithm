/**
 * BinarySearch
 */
public class BinarySearch {

    public static int binarySearch(int arr[], int key, int size) {
        int start = 0;
        int end = size - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == key)
                return mid;
            else if (key > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;

            mid = start + (end - start) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int even[] = new int[] { 1, 2, 10, 23, 27, 80 };

        int index = binarySearch(even, 27, even.length);
        System.out.println(index);

    }
}