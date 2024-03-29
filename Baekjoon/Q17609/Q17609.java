package Baekjoon.Q17609;

import java.util.*;
import java.io.*;

public class Q17609 {
    public static int twoPointer(char[] str) {
        int start = 0;
        int end = str.length - 1;
        boolean checker = false;
        while (start < end) {
            if (str[start] == str[end]) {
                start++;
                end--;
            } else if (str[start] != str[end] && !checker) {
                if (str[start + 1] == str[end]) {
                    start++;
                } else if (str[start] == str[end - 1]) {
                    end--;
                } else {
                    return 2;
                }
                checker = true;
            } else if (str[start] != str[end] && checker){
                return 2;
            }
        }
        if (checker) return 1;
        return 0;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            char[] str = br.readLine().toCharArray();
            System.out.println(twoPointer(str));
        }
    }
}
//stkoeestseokts
//stkoestseokts
//stkoestseeokts
//stkoesttseokts
//stkoesttsteokkts
//stkoesttsgeokts
//stkqoesttseokts