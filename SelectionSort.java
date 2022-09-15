public class SelectionSort {
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

    public static void selectionSort(int arr[], int n) {

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            swap(arr, i, minIdx);

        }

    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 6, 1, 88, 22, 1 };
        int n = arr.length;

        selectionSort(arr, n);
        printArr(arr);

    }
}
