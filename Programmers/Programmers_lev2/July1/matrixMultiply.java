package Programmers_lev2.July1;

public class matrixMultiply {
    public static void main(String[] args) {
        Solution701_2.solution(new int[][] {{1,4}, {3,2}, {4,1}}, new int[][] {{3,3, 1}, {3,3, 1}});
    }
}

class Solution701_2 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        return answer;
    }
}
