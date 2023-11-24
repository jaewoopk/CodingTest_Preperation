package Baekjoon.Q1759;

import java.util.*;
import java.io.*;

public class Q1759 {
    static int l, c;
    static char[] arr;
    static Character[] chArr;
    static int[] isVowel;
    static boolean[] visited;
    public static void getIsVowel() {
        for (int i = 0; i < c; i++) {
            if (chArr[i] == 'a' || chArr[i] == 'e' || chArr[i] == 'i' || chArr[i] == 'o' || chArr[i] == 'u') {
                isVowel[i] = 1;
            } else {
                isVowel[i] = 0;
            }
        }
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
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = chArr[i];
                if (isVowel[i] == 1) {
                    dfs(idx + 1, i, vowel + 1, cons);
                } else {
                    dfs(idx + 1, i, vowel, cons + 1);
                }
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        chArr = br.readLine().replaceAll(" ", "")
                             .chars()
                             .mapToObj(c -> (char) c)
                             .toArray(Character[]::new);

        Arrays.sort(chArr);
        isVowel = new int[c];
        getIsVowel();
        arr = new char[l];
        visited = new boolean[c];

        dfs(0, -1, 0, 0);

        br.close();
    }
}
