package SWEA.D2.Q2007;

import java.util.*;
import java.io.*;

public class Q2007 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            int max = -1;
            String line = br.readLine();
            for (int i = 1; i <= 10; i++) {
                String[] words = new String[10];
                words[0] = line.substring(0,i);
                words[1] = line.substring(i,i * 2);

                if (words[0].equals(words[1]) && max < i) {
                    max = i;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}