package TestProgrammers;

import javax.sound.sampled.SourceDataLine;

public class Q5 {
    class Solution {
        int n;
        int max;
        boolean[] visited;
    
        public void backTracking(int[][] arr, int idx, int k) {
            if (idx == n) {
                max = idx;
                return ;
            }
    
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (k >= arr[i][0]) {
                        k -= arr[i][1];
                        backTracking(arr, idx + 1, k);
                        k += arr[i][1];
                    }
                    visited[i] = false;
                }
            }
    
            if (max < idx) {
                max = idx;
            }
        }
    
        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            n = dungeons.length;
            max = 0;
            visited = new boolean[n];
            backTracking(dungeons, 0, k);
            answer = max;
            return answer;
        }
    }
}
