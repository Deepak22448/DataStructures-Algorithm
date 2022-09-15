public class BubbleSort {
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

    public static void bubbleSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n - i; j++) {

                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);

            }

        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 1, 7, 2, 4, 9, 42 };
        int n = arr.length;

        bubbleSort(arr, n);
        printArr(arr);
    }
}
