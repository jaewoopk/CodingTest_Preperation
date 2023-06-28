package Programmers_lev2.June28;

public class longJump {
    public static void main(String[] args) {
        // System.out.println(Solution628_1.solution(4));
        // System.out.println(Solution628_1.solution(3));
    }
}

class Solution628_1 {
    public long solution(int n) {
        long[] arr = new long[n + 3];
        arr[1] = 1;
        arr[2] = 2; 
        for (int i = 3 ; i < n + 2; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        return arr[n];
    }    
}

// class Solution628_1 {
//     long count = 0;
//     public void recursive(int sum, int n) {
//         if (sum == n) {
//             count = (count + 1) % 1234567;
//             return ;
//         }
//         else if (sum > n) {
//             return ;
//         }
//         recursive(sum + 1, n);
//         recursive(sum + 2, n);
//     }
//     public long solution(int n) {
//         recursive(0, n);
//         return count;
//     }    
// }
