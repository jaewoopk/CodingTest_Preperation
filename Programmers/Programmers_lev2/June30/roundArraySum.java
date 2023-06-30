package Programmers_lev2.June30;

import java.util.*;

public class roundArraySum {
    public static void main(String[] args) {
    
    }
}

class Solution630_2 {
    Set<Integer> set = new HashSet<Integer>();
    
    public void slidingWindow(int[] elements, int w) {
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + w; j++) {
                int tmp = j;
                if (tmp > elements.length - 1) {
                    tmp = j - elements.length;
                }
                sum += elements[tmp];
            }
            set.add(sum);
        }
    }
    public int solution(int[] elements) {
        for (int i = 1; i <= elements.length;i++) {
            slidingWindow(elements,i);   
        }
        return set.size();
    }
}
