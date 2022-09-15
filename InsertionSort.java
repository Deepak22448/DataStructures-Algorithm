public class InsertionSort {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int arr[]) {
        for (int val : arr)
            System.out.print(val + " ");

        System.out.println();
    }

    public static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 3, 423, 5, 2, 5, 12, 421, 2 };
        int n = arr.length;
        insertionSort(arr, n);

        printArr(arr);
    }
}
