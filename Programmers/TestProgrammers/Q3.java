package TestProgrammers;

public class Q3 {
    public static void main(String[] args) {
        String s1 = "1 2 3 4";
        String s2 = "-1 -2 3 -4";

        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");
        for (var e : split1) {
            int a = Integer.parseInt(e);
            System.out.println(a);
        }

        for (var e : split2) {
            int a = Integer.parseInt(e);
            System.out.println(a);
        }
    }

    class Solution {
        public String solution(String s) {

            String answer = "";
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            // for (int i = 0; i < s.length(); i++) {
            //     if (s.charAt(i) == ' ') {
            //         continue ;
            //     }
            //     if (s.charAt(i) == '-') {
            //         i++;
            //         if (-(int)(s.charAt(i)) - '0' > max) {
            //             max = -(int)(s.charAt(i) - '0');
            //         }
            //         if (-(int)(s.charAt(i)) - '0' < min) {
            //             min = -(int)(s.charAt(i) - '0');
            //         }    
            //     }
            //     else {
            //         if ((int)(s.charAt(i)) - '0' > max) {
            //             max = (int)(s.charAt(i) - '0');
            //         }
            //         if ((int)(s.charAt(i)) - '0' < min) {
            //             min = (int)(s.charAt(i) - '0');
            //         }   
            //     }
            // }
            // answer = Integer.toString(min) + " " + Integer.toString(max);
            System.out.println(min + " " + max);
            return answer;
        }
    }
}
