
public class Recursion {
    public static void printArr(int arr[]) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int arr[], int n) {
        if (n == 0 || n == 1)
            return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                swap(arr, i, i + 1);
        }
        bubbleSort(arr, n - 1);
    }

    public static boolean checkPalindrome(String str, int start, int n) {
        if (str.length() / 2 > (n - 1 - start))
            return true;

        if (str.charAt(start) == str.charAt(n - 1 - start))
            return checkPalindrome(str, start + 1, n);

        return false;

    }

    public static boolean checkPalindrome(String str, int n) {
        String reverse = reverse(str, 0, n - 1);
        return reverse.equals(str);
    }

    public static String swap(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (char s : str.toCharArray())
            sb.append(s);

        sb.setCharAt(start, str.charAt(end));
        sb.setCharAt(end, str.charAt(start));

        return sb.toString();

    }

    public static String reverse(String str, int start, int end) {
        if (start > end) {
            return str;
        }
        str = swap(str, start, end);
        return reverse(str, start + 1, end - 1);
    }

    public static void printArr(int arr[], int s, int e) {
        for (int i = s; i <= e; i++)
            System.out.print(arr[i] + " ");

        System.out.println("start " + s + " end " + e);
    }

    public static int binarySearch(int arr[], int start, int end, int target) {
        if (start > end)
            return -1;
        printArr(arr, start, end);
        int mid = start + (end - start) / 2;
        if (arr[mid] == target)
            return mid;

        if (arr[mid] > target)
            return binarySearch(arr, start, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, end, target);

    }

    public static int getSum(int arr[], int index, int n) {
        if (index == n - 1)
            return arr[index];
        return arr[index] + getSum(arr, index + 1, n);

    }

    public static boolean isSorted(int arr[], int index, int n) {
        if (index == n - 1)
            return true;

        if (arr[index] <= arr[index + 1])
            return isSorted(arr, index + 1, n);

        return false;

    }

    public static int power(int a, int b) {
        /* base case. */
        if (b == 1)
            return a;

        /* For even case */
        if (b % 2 == 0)
            return power(a * a, b / 2);

        /* For Odd case */
        return power(a * a, b / 2) * a;

    }

    public static void main(String[] args) {
        int arr[] = { 4, 10, 115, 8, 3 };
        int n = arr.length;

        bubbleSort(arr, n);
        printArr(arr);

    }
}
