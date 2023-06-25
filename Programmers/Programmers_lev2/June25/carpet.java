package Programmers_lev2.June25;


public class carpet {
    public static void main(String[] args) {
        for (var e : Solution625_1.solution(10, 2)) {
            System.out.println(e);
        }
        for (var e : Solution625_1.solution(8, 1)) {
            System.out.println(e);
        }
        for (var e : Solution625_1.solution(24, 24)) {
            System.out.println(e);
        }
    }
}

class Solution625_1 {
    public static int[] solution(int brown, int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            int x = 4 * (i + 2) - 4;
            int xIdx = 1;
            for (int j = x; j <= brown; j += 2) {
                if (j == brown && yellow == i * i + i * (xIdx - 1)) {
                    return new int[]{i + 2 + xIdx - 1, i + 2};
                }
                xIdx++;
            }
        }
        return new int[]{1,1};
    }
}