import java.util.Scanner;

public class GCD {
    public static int power(int a, int b) {
        int res = 1;

        while (b > 0) {
            if (b % 2 != 0) {
                res *= a;
                System.out.println(res);
            }
            a *= a;
            b /= 2;
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;

        if (b == 0)
            return a;

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = power(a, b);

        // int ans = gcd(a, b);

        // System.out.println("GCD of " + a + " , " + b + " is " + ans);
        System.out.println(ans);
    }
}
