package SWEA.D3.Q18662;

import java.util.*;
import java.io.*;

public class Q18662 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            double min = Double.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            double a, b, c;
            a = Double.parseDouble(st.nextToken());
            b = Double.parseDouble(st.nextToken());
            c = Double.parseDouble(st.nextToken());

            min = Math.min(Math.abs(a + c - 2 * b), min);
            System.out.println("#" + test_case + " " + min / 2);
        }
    }
}
