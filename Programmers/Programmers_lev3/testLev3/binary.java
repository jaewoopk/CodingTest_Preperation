package Programmers_lev3.testLev3;

import java.util.*;

public class binary {
    public static void main(String[] args) {
        System.out.println(Solution.solution(6, new int[] {7,10}));
    }
}

class Solution {
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1]; // 최대 시간

        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < times.length; i++){
                sum += mid / times[i]; // 각 심사관이 mid 시간동안 심사할 수 있는 사람의 수를 모두 합산
            }

            if(sum < n){ // n명보다 적으면
                left = mid + 1;
            } else{ // n명 이상이면
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}

