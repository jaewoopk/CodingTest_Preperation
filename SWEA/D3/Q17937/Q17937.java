package SWEA.D3.Q17937;

import java.util.*;
import java.io.*;

class Q17937 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            String[] str = br.readLine().split(" ");
            if (str[0].equals(str[1])) {
                System.out.println("#"+ test_case + " " + str[0]);
            } else {
                System.out.println("#"+ test_case + " " + 1);
            }
        }
    }
}