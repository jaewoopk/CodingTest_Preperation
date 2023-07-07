package SoftwareMaestro.SoftwareMaestro_Preperation;

public class Question2 {
    public static void main(String[] args) {
        Solution.solution(args);
    }
}

// 일일이 하나하나 대조를 해야하는 것 같다.
class Solution {
    public static char[][] answerBoard;

    public static int findWinning(char c) {
        int game = 0;
        for(int i = 0; i < 3; i++) {
            if (answerBoard[i][0] == c &&
                answerBoard[i][0] == answerBoard[i][1] && 
                answerBoard[i][1] == answerBoard[i][2])
                game++;
            if (answerBoard[0][i] == c && 
                answerBoard[0][i] == answerBoard[1][i] && 
                answerBoard[1][i] == answerBoard[2][i])
                game++;
        }
        if (answerBoard[0][0] == c && 
            answerBoard[0][0] == answerBoard[1][1] && 
            answerBoard[1][1] == answerBoard[2][2])
            game++;
        if (answerBoard[0][2] == c && 
            answerBoard[0][2] == answerBoard[1][1] && 
            answerBoard[1][1] == answerBoard[2][0])
            game++;
        return game;
    }
    public static int solution(String[] board) {
        int answer = 1;
        answerBoard = new char[3][3];
        int oCnt = 0;
        int xCnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                answerBoard[i][j] = board[i].charAt(j);
                if (answerBoard[i][j] == 'O')
                    oCnt++;
                else if (answerBoard[i][j] == 'X')
                    xCnt++;
            }
        }
        if (xCnt > oCnt || oCnt - xCnt > 1)
            return 0;
        if (findWinning('O') > 0 &&  findWinning('X') > 0)
            return 0;
        if (findWinning('O') > 0) {
            if (oCnt == xCnt)
                return 0;
        }
        if (findWinning('X') > 0) {
            if (oCnt > xCnt)
                return 0;
        }
        return answer;
    }
}

// class Solution {
//     public int solution(String[] board) {
//         int answer = 1;
//         ArrayList<String> idxArr = new ArrayList<>();
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 if (board[i].charAt(j) == 'O') {
//                     idxArr.add("O");
//                 }
//                 else if (board[i].charAt(j) == 'X') {
//                     idxArr.add("X");
//                 }
//             }
//         }
//         int cnt = 0;
//         for (var e : idxArr) {
//             if (e.equals("O")) {
//                 cnt++;
//             }
//             else {
//                 cnt--;
//             }
//         }
//         if (cnt != 0) {
//             answer = 0;
//         }
//         return answer;
//     }
    
// }