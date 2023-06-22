package Programmers_lev2.June22;

public class fibonacciNumber {
    public static void main(String[] args) {
        System.out.println(Solution622_1.solution(3));
        System.out.println(Solution622_1.solution(5));
    }    
}

class Solution622_1 {
    public static int solution(int n) {
        int[] arr = new int[100001];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 100000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        return arr[n];
    }
}
