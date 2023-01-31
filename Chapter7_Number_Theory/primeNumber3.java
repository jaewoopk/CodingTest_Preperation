package Chapter7_Number_Theory;

import java.util.Scanner;

public class primeNumber3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[10000001];
        arr[1] = 1;
        for (int i = 2; i < 10000001; i++) {
            for (int j = i + i; j < 10000001; j += i) {
                if (arr[j] == 1) {
                    continue;
                }
                else {
                    arr[j] = 1;
                }
            }
        }

        for (int i = n; i < 10000001; i++) {
            if (arr[i] == 0) {
                if (findPd(i) == -1) {
                    continue ;
                }
                else {
                    System.out.println(i);
                    break ;
                }
            }
        }

        sc.close();
    }
    static int findPd(int x) {
        String str = Integer.toString(x);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
                continue;
            }
            else {
                return -1;
            }
        }
        return x;
    }
}
