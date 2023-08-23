package Programmers_lev2.FindPrimeNum;

import java.util.*;

public class findPrimeNum {
    public static void main(String[] args) {
        System.out.println(Solution.solution(437674, 3));
        System.out.println(Solution.solution(110011, 10));
        System.out.println(Solution.solution(2100020113, 9));
    }
}

class Solution {
    static int count;
//    public static String makeKjinsu(int n, int k) {
//        StringBuilder sb = new StringBuilder();
//        int division = 0;
//        while (n > 0) {
//            division = n % k;
//            n /= k;
//            sb.append(Integer.toString(division));
//        }
//        return sb.reverse().toString();
//    }

    public static void isPrime(long num) {
        if (num == 1) return ;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return ;
            }
        }
        count++;
    }
    public static int solution(int n, int k) {
        //String str = makeKjinsu(n, k);
        //String[] nums = str.split("0");

        String[] nums = Integer.toString(n, k).split("0"); // -> 이렇게 해서 윗 부분을 줄일 수 있다.

        //System.out.println(Arrays.toString(nums));
        for (String e : nums) {
            if (!e.equals("")) {
                isPrime(Long.parseLong(e));
            }
        }
        return count;
    }
}
