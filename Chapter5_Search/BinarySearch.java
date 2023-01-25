package Chapter5_Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x, first, mid, end, count;
            Boolean check = false;
            first = 0;
            end = n - 1;
            x = Integer.parseInt(st.nextToken());
            mid = (first + end) / 2;
            count = ((int)Math.sqrt(n)) + 1;
            for (int j = 0; j < count; j++) {
                if (arr[mid] > x) {
                    end = mid;
                }
                else if (arr[mid] < x){
                    first = mid + 1;
                }
                if (arr[mid] == x){
                    check = true;
                    break ;
                }
                else if (mid >= n - 1 || mid <= 0) {
                    check = false;
                    break ;
                }
                mid = (first + end) / 2;
            }
            if (check) {
                bw.write("1\n");
            }
            else {
                bw.write("0\n");
            }
        }


        bw.close();

    }
}
