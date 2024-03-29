package Programmers_lev2.Curse3;

public class curse3 {
    public static void main(String[] args) {
        System.out.println(Solution.solution(40));
    }
}

class Solution {
    public static int solution(int n) {
        int[] arr = new int[101];
        int num = 1;
        for (int i = 1; i < n + 1; i++) {
            while (num % 3 == 0 || Integer.toString(num).contains("3")) {
                num++;
            }
            arr[i] = num;
            num++;
        }
        return arr[n];
    }
}
// 첫 번째 풀이
//class Solution {
//    public static int solution(int n) {
//        int num = 1;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i < 300; i++) {
//            if (i % 3 == 0 || i % 10 == 3 || i / 10 == 3 || (i % 100) / 10 == 3) {
//                continue;
//            }
//            list.add(i);
//            System.out.println(i);
//        }
//        return list.get(n - 1);
//    }
//}