package Baekjoon.Q20055;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Q20055 {
    static int n, k, count, answer;
    static boolean[] robots;
    static int[] arr;
    static boolean checking(int[] arr) {
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                check++;
            }
        }
        return check < k;
    }
    static Deque<Integer> rotate(Deque<Integer> dq) {
        dq.addFirst(dq.pollLast());
        for (int i = n - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = false;
        robots[n - 1] = false;
        return dq;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;
        answer = 0;
        robots = new boolean[n];

        Deque<Integer> dq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        arr = dq.stream().mapToInt(Integer::intValue).toArray();
        while (checking(arr)) {
            rotate(dq);
            arr = dq.stream().mapToInt(Integer::intValue).toArray();

            for (int i = n - 1; i > 0; i--) {
                if ((robots[i - 1] && !robots[i]) && arr[i] > 0) {
                    robots[i - 1] = false;
                    robots[i] = true;
                    arr[i]--;
                }
            }

            if (arr[0] > 0) {
                robots[0] = true;
                arr[0]--;
            }
            dq = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayDeque::new));
            answer++;
        }
        System.out.println(answer);
    }
}
