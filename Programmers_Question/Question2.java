package Programmers_Question;

import java.util.ArrayList;

public class Question2 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int solution(String[] board) {
        int answer = 1;
        ArrayList<String> idxArr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    idxArr.add("O");
                }
                else if (board[i].charAt(j) == 'X') {
                    idxArr.add("X");
                }
            }
        }
        int cnt = 0;
        for (var e : idxArr) {
            if (e.equals("O")) {
                cnt++;
            }
            else {
                cnt--;
            }
        }
        if (cnt != 0) {
            answer = 0;
        }
        return answer;
    }
    
}