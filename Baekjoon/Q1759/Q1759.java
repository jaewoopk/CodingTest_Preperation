package Baekjoon.Q1759;

import java.util.*;
import java.io.*;

public class Q1759 {
    static int l, c;
    static char[] arr;
    static char[] chArr;
    static boolean[] isVowel;
    public static boolean[] getIsVowel() {
        boolean[] tmp = new boolean[c];
        for (int i = 0; i < c; i++) {
            tmp[i] = chArr[i] == 'a' || chArr[i] == 'e' || chArr[i] == 'i' || chArr[i] == 'o' || chArr[i] == 'u';
        }
        return tmp;
    }
    public static void dfs(int idx, int x, int vowel, int cons) {
        if (idx == l) {
            if (vowel >= 1 && cons >= 2) {
                for (var e : arr) {
                    System.out.print(e);
                }
                System.out.println();
            }
            return;
        }
        for (int i = x + 1; i < c; i++) {
            arr[idx] = chArr[i];
            if (isVowel[i]) {
                dfs(idx + 1, i, vowel + 1, cons);
            } else {
                dfs(idx + 1, i, vowel, cons + 1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        chArr = br.readLine().replaceAll(" ", "").toCharArray();

        Arrays.sort(chArr);
        isVowel = getIsVowel();
        arr = new char[l];

        dfs(0, -1, 0, 0);

        br.close();
    }
}