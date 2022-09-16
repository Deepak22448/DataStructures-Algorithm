import javax.swing.text.html.MinimalHTMLWriter;

public class MergeSort {

    public static void printArr(int arr[]) {

        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();

    }

    public static void merge(int arr[], int start, int mid, int end) {

        int merged[] = new int[end - start + 1];

        int x = 0;
        int idx1 = start;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] < arr[idx2])
                merged[x++] = arr[idx1++];
            else
                merged[x++] = arr[idx2++];
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= end) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            mergeSort(arr, start, mid);
            ;
            mergeSort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 5, 11, 2, -1, 5, -66 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

        printArr(arr);
    }
}
