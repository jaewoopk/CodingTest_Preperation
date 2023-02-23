package TestProgrammers;

public class Q4 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
    
            for (int i = 1; i <= n / 2; i++) {
                int sum = i;
                for (int j = i + 1; j <= n / 2 + 1; j++) {
                    sum += j;
                    if (sum == n) {
                        answer++;
                    }
                    else if (sum > n) {
                        break ;
                    }
                }
            }
            return ++answer;
        }
    
    }
}
