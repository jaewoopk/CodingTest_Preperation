package TestProgrammers;

import java.util.PriorityQueue;

public class Q3 {
    class Solution {
        public String solution(String s) {

            String answer = "";
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    continue ;
                }
                if (s.charAt(i) == '-') {
                    i++;
                    if (-(int)(s.charAt(i)) - '0' > max) {
                        max = -(int)(s.charAt(i) - '0');
                    }
                    if (-(int)(s.charAt(i)) - '0' < min) {
                        min = -(int)(s.charAt(i) - '0');
                    }    
                }
                else {
                    if ((int)(s.charAt(i)) - '0' > max) {
                        max = (int)(s.charAt(i) - '0');
                    }
                    if ((int)(s.charAt(i)) - '0' < min) {
                        min = (int)(s.charAt(i) - '0');
                    }   
                }
            }
            answer = Integer.toString(min) + " " + Integer.toString(max);
            System.out.println(min + " " + max);
            return answer;
        }
    }
}
