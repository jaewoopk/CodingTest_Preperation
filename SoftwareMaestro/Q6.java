package SoftwareMaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[1001][3];

        st = new StringTokenizer(br.readLine());
        arr[1][0] = Integer.parseInt(st.nextToken());
        arr[1][1] = Integer.parseInt(st.nextToken());
        arr[1][2] = Integer.parseInt(st.nextToken());
        for (int i = 2; i < n + 1; i++ ) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            arr[i][0] += Math.min(arr[i - 1][1],arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0],arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][0],arr[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(arr[n][0], arr[n][1]), arr[n][2]));
    }
}
