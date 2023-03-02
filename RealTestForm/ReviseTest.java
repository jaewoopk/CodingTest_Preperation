package RealTestForm;

public class ReviseTest {
    static int count;
    static int[][] board;
    static void Recursive(int x, int y, int len) {
        int[] xValue = {len * 1, 0, len * -1, 0};
        int[] yValue = {0, len * 1, 0, len * -1};
        int check = 0;

        for (int i = 0; i < 4; i++) {
            int px = x + xValue[i];
            int py = y + yValue[i];

            if (px < 0 || px > 100 || py < 0 || py > 100) {
                continue ;
            }
            if (len >= 2 && (px > 0 && px < 100) && (py > 0 && py < 100)) {
                if ((i == 0 || i == 2) && (board[px][py + 1] == 1 || board[px][py - 1] == 1)) {
                    break ;
                }
                else if ((i == 1 || i == 3) && (board[px + 1][py] == 1 || board[px - 1][py] == 1)){
                    break ;
                }
            }
            if (board[px][py] == 1) {
                check++;
            }
            else {
                break ;
            }
        }
        if (check == 4) {
            count = Math.max(count, len);
            Recursive(x, y, len + 1);
        }
    }
    public static void main(String[] args) {
        board = new int[101][101];

        int[][] gived = {{2,5,9,5}, {8,2,8,8}, {5,10,5,2}, {2,8,6,8}};

        for (int i = 0; i < gived.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (gived[i][0] == gived[i][2]) {
                    for (int k = Math.min(gived[i][1], gived[i][3]); k < Math.max(gived[i][1], gived[i][3]); k++) {
                        board[k][gived[i][0]] = 1;
                    }
                }
                else {
                    for (int k = Math.min(gived[i][0], gived[i][2]); k < Math.max(gived[i][0], gived[i][2]); k++) {
                        board[gived[i][1]][k] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (board[i][j] == 1) {
                    Recursive(i, j, 1);
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(count);
    }
}
