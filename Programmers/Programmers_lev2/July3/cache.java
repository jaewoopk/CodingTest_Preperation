package Programmers_lev2.July3;

import java.util.LinkedList;

public class cache {
    public static void main(String[] args) {

    }
}

class Solution703_1 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        for (var city : cities) {
            city = city.toLowerCase();

            if (list.contains(city)) {
                list.remove(city);
                list.addFirst(city);
                answer += 1;
            } else {
                if (list.size() >= cacheSize) {
                    list.pollLast();
                }
                list.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }
}
