package Baekjoon.Q1339;

import java.io.*;
import java.util.*;

public class findWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();

            int pow = (int) Math.pow(10, word.length - 1);
            for (char c : word) {
                alpha[c - 'A'] += pow;
                pow /= 10;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            System.out.println(alpha[i]);
            if (alpha[i] != 0) {
                list.add(alpha[i]);
            }
        }

        list.sort(Collections.reverseOrder());

        int ans = 0;
        int num = 9;
        for (int val : list) {
            ans += val * num--;
        }
        System.out.println(ans);
    }
}
