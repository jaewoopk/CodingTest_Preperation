package Baekjoon.Q1593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringDecode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        String S = br.readLine();

        System.out.println(Solution.solution(g,s,W,S));
    }
}

class Solution {
    public static int charIndex(String W, int i) {
        if (W.charAt(i) >= 'A' && W.charAt(i) <= 'Z') {
            return W.charAt(i) - 'A';
        } else {
            return W.charAt(i) - 'a' + 26;
        }
    }

    public static int solution(int g, int s, String W, String S) {
        int count = 0;
        int[] wCount = new int[52];
        int[] sCount = new int[52];

        for (int i = 0; i < g; i++) {
            wCount[charIndex(W,i)]++;
            sCount[charIndex(S,i)]++;
        }
        if (Arrays.equals(wCount, sCount)) {
            count++;
        }

        for (int i = g; i < S.length(); i++) {
            sCount[charIndex(S,i - g)]--;
            sCount[charIndex(S,i)]++;

            if (Arrays.equals(wCount, sCount)) {
                count++;
            }
        }
        return count;
    }
}

