package RealTestForm;

class Solution {
    static int count = 0;
    static boolean visited[];

    public static boolean isPrime(int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void backTracking(int[] arr, int idx, int sum, int beforeIdx) {
        if (idx == 3) {
            if (isPrime(sum)) {
                count++;
            }
            return ;
        }
        for (int i = 0; i < arr.length - (2 - idx); i++) {
            if (!visited[i] && beforeIdx < i) {
                visited[i] = true;
                backTracking(arr, idx + 1, sum + arr[i], i);
                visited[i] = false;
            }
        }
    }
    public static int solution(int[] nums) {
        int answer = -1;

        visited = new boolean[nums.length];

        backTracking(nums, 0, 0, -1);

        answer = count;
        return answer;
    }
}


public class BackTracking extends Solution{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int answer = -1;
        answer = solution(arr);
        System.out.println(answer);
    }
}