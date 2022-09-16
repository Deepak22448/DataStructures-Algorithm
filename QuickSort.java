public class QuickSort {
    public static void printArr(int arr[]) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();

    }

    public static int pivot(int arr[], int start, int end) {
        int pivot = arr[end];
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                int temp = arr[start];
                arr[start] = arr[j];
                arr[j] = temp;

                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        return start;

    }

    public static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int pivot = pivot(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 11, 2, -1, 5, -66 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);

        printArr(arr);
    }
}
