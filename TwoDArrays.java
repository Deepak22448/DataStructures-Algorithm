
public class TwoDArrays {

    public static void printWave(int arr[][], int n, int m) {
        for (int col = 0; col < m; col++) {
            boolean isEven = col % 2 == 0;
            if (isEven) {
                for (int row = 0; row < n; row++) {
                    System.out.print(arr[row][col] + " ");
                }

            } else {
                for (int row = n - 1; row >= 0; row--) {
                    System.out.print(arr[row][col] + " ");
                }
            }
            System.out.println();

        }
    }

    public static void printRowSum(int arr[][], int n, int m) {
        int idx = -1;
        int max = -1;
        for (int row = 0; row < n; row++) {
            int sum = 0;
            for (int col = 0; col < m; col++) {
                sum += arr[row][col];
            }

            if (sum > max) {
                max = sum;
                idx = row;
            }
            System.out.println(row + " row sum is " + sum);
        }
        System.out.println("Max Row Sum is " + max + " at Row number " + idx);
    }

    public static boolean isPresent(int arr[][], int n, int m, int key) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (arr[row][col] == key)
                    return true;
            }
        }
        return false;
    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }

}