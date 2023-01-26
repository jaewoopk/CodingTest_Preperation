package Chapter6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int count = 0;
        for (int i = n - 1; i > -1; i--) {
            count = 0;
            if (k / arr[i] > 0) {
                count = (k / arr[i]);
                k -= (count * arr[i]);
                answer += count;
            }
            if (k == 0) {
                break ;
            }
        }
        System.out.println(answer);
    }
}
