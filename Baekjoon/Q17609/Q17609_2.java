package Baekjoon.Q17609;

import java.util.*;
import java.io.*;

public class Q17609_2 {
    public static boolean isPalindrome(char[] s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int twoPointer(char[] str) {
        int start = 0;
        int end = str.length - 1;
        while (start < end) {
            if (str[start] == str[end]) {
                start++;
                end--;
            } else {
                if (isPalindrome(str, start + 1, end) || isPalindrome(str, start, end - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
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