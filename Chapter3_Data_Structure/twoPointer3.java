package Chapter3_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class twoPointer3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end;
        int cmp = end = n - 1;
        int count = 0;

        while (cmp > -1) {
            while (start < end) {
                if (arr[start] + arr[end] == arr[cmp]) {
                    if (start != cmp && end != cmp) {
                        count++;
                        break ;
                    }
                    else if (start == cmp) {
                        start++;
                    }
                    else if (end == cmp) {
                        end--;
                    }
                }
                else if (arr[start] + arr[end] > arr[cmp]) {
                    end--;
                }
                else {
                    start++;
                }
            }
            cmp--;
            end = n - 1;
            start = 0;
        }
        System.out.println(count);
    }
}
