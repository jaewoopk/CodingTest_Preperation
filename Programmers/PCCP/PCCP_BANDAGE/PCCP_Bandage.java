package PCCP.PCCP_BANDAGE;

public class PCCP_Bandage {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {5, 1, 5}, 30, new int[][] {{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
    }
}
class Solution {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int idx = 0;
        final int maximum = health;
        int continue_success = 0;

        for (int i = 0; i < attacks[attacks.length - 1][0] + 1; i++) {
            if (attacks[idx][0] == i) {
                if (health - attacks[idx][1] <= 0)
                    return -1;
                else {
                    health -= attacks[idx][1];
                    continue_success = 0;
                }
                idx++;
            } else {
                continue_success++;
                if (health + bandage[1] >= maximum) {
                    health = maximum;
                } else {
                    health += bandage[1];
                }
            }
            if (continue_success == bandage[0]) {
                continue_success = 0;
                if (health + bandage[2] >= maximum) {
                    health = maximum;
                } else {
                    health += bandage[2];
                }
            }
        }
        return health;
    }
}
