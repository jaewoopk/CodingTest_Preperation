package SWEA.D3.Q1244;
//
//import java.util.*;
//import java.io.*;
//
//public class Q1244 {
//    static int n, m;
//    static int max;
//    static int[] arr;
//    static boolean[] visited;
//    public static int arrayToInt() {
//        StringBuilder sb = new StringBuilder();
//        for (int e : arr) {
//            sb.append(e);
//        }
//        return Integer.parseInt(sb.toString());
//    }
//    public static void backtracking(int idx, int count) {
//        if (idx >= arr.length) {
//            if (count == m || m % 2 == count % 2 && max < arrayToInt()) {
//                max = arrayToInt();
//            }
//            return ;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                if (arr[idx] > arr[i]) {
//                    int tmp = arr[idx];
//                    arr[idx] = arr[i];
//                    arr[i] = tmp;
//                    backtracking(idx + 1, count + 1);
//                    tmp = arr[idx];
//                    arr[idx] = arr[i];
//                    arr[i] = tmp;
//                }
//                backtracking(idx + 1, count);
//                visited[i] = false;
//            }
//        }
//    }
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int C = Integer.parseInt(st.nextToken());
//
//        for (int i = 1; i < C + 1; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            n = Integer.parseInt(st.nextToken());
//            m = Integer.parseInt(st.nextToken());
//            arr = Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).toArray();
//            max = arrayToInt();
//            visited = new boolean[arr.length];
//
//            backtracking(0, 0);
//
//            System.out.println("#" + i + " " + max);
//        }
//    }
//}
//
////#1 321
////        #2 7732
////        #3 857147
////        #4 87664
////        #5 88832
////        #6 777770
////        #7 966354
////        #8 954311
////        #9 332211
////        #10 987645

import java.util.Scanner;

public class Q1244 {
    static String[] arr;
    static int max, chance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1 ; test_case <= T ; test_case++) {
            arr = sc.next().split("");
            chance = sc.nextInt();

            max = 0;
            // 시간초과 최적화
            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
                chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }
    static void dfs(int start, int cnt) {
        if(cnt == chance) {
            String result = "";
            for(String s : arr)
                result += s;
            max = Math.max(max, Integer.parseInt(result));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                // swap
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, cnt + 1);	// 깊이 +1
                // 다시 swap 해서 되돌림
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
//10
//123 1
//2737 1
//757148 1
//78466 2
//32888 2
//777770 5
//436659 2
//431159 7
//112233 3
//456789 9