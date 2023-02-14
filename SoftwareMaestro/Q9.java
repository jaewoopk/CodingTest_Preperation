package SoftwareMaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q9 {
    static int n;
    static boolean[][] visited;
    static int[][] arr;
    static int count;
    static int counting;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        LinkedList<Integer> answer = new LinkedList<>();
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = (int)(str.charAt(j - 1) - '0');
            }
        }

        counting = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    counting++;
                    myDfs2(i, j);
                    answer.add(++count);
                    count = 0;
                }
            }
        }

        answer.sort(null);

        System.out.println(counting);
        for (var e : answer) {
            System.out.println(e);
        }
    }

    static void myDfs2(int x, int y) {
        visited[x][y] = true;
        int[] xArr = {1 , 0, -1 ,0};
        int[] yArr = {0 , 1, 0 ,-1};
        for (int i = 0; i < 4; i++) {
            if (x + xArr[i] > n || y + yArr[i] > n) {
                continue ;
            }
            if (!visited[x + xArr[i]][y + yArr[i]] && arr[x + xArr[i]][y + yArr[i]] != 0) {
                myDfs2(x + xArr[i], y + yArr[i]);
                count++;
            }
        }
    }
}
