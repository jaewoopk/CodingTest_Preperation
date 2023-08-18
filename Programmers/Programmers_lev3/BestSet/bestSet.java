package Programmers_lev3.BestSet;

import java.util.Arrays;

public class bestSet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(2, 9)));
        System.out.println(Arrays.toString(Solution.solution(3, 10)));
        System.out.println(Arrays.toString(Solution.solution(4, 82)));
    }
}
class Solution {
    public static int[] solution(int n, int s) {
        if (s < n) {
            return new int[] {-1};
        }

        int[] answer = new int[n];
        int moc = s;
        int left = s;
        int count = n;

        for (int i = 0; i < n - 1; i++) {
            int tmp = moc;
            moc = left / count--; // 4
            left = tmp - moc; // 5
            answer[i] = moc;
            moc = left;
        }
        answer[n - 1] = moc;
        return answer;
    }
}

// 더 간결하게

//package Programmers_lev3.BestSet;
//
//        import java.util.Arrays;
//
//public class bestSet {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(Solution.solution(2, 9)));
//        System.out.println(Arrays.toString(Solution.solution(3, 10)));
//        System.out.println(Arrays.toString(Solution.solution(4, 82)));
//    }
//}
//
//class Solution {
//    public static int[] solution(int n, int s) {
//        if (s < n) return new int[] {-1};
//
//        int[] answer = new int[n];
//        Arrays.fill(answer, s / n);
//
//        for (int i = n - 1; i >= n - s % n; i--) {
//            answer[i]++;
//        }
//
//        return answer;
//    }
//}
