package Programmers_lev2.June27;

import java.util.Arrays;

public class LCMnums {
    public static void main(String[] args) {
        int[] arr1 = {2,6,8,14};
        System.out.println(Solution627_2.solution(arr1));
    }
}

class Solution627_2 {
    public static int GCD(int a, int b) {
        if (b % a == 0) return a;
        else return GCD(b % a, a);
    }
    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            arr[i + 1] = LCM(arr[i], arr[i + 1]);
        }
        return arr[len - 1];
    }
}
