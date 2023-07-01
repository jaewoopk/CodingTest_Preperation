package Programmers_lev2.July1;

public class cuttingArray {
    public static void main(String[] args) {
        for (var e : Solution701_1.solution(4, 7, 14)) {
            System.out.println(e);
        }
    }
}

class Solution701_1 {
    public static int[] solution(int n, long left, long right) {
        int leftMoc = (int)(left / n);
        int leftNa = (int)(left % n);

        int len = (int)(right - left + 1); 
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            if (leftMoc >= leftNa) {
                answer[i] = leftMoc + 1;
                leftNa++;
            }
            else if (leftNa <= n - 1 && leftMoc < leftNa){
                answer[i] = leftNa + 1;
                leftNa++;
            }
            else if (leftNa > n - 1){
                leftMoc++;
                answer[i] = leftMoc + 1;
                leftNa = 1;
            }
        }

        return answer;
    }
}


// import java.util.Arrays;
// import java.util.stream.LongStream;

// class Solution {
//     public int[] solution(int n, long left, long right) {
//         return LongStream.rangeClosed(left, right).mapToInt(value -> (int) (Math.max(value / n, value % n) + 1)).toArray();
//     }
// }