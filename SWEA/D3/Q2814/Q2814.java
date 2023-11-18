package SWEA.D3.Q2814;

import java.util.*;
import java.io.*;

public class Q2814 {
    static boolean[] visited;
    static int max;
    static HashMap<Integer, List<Integer>> map;
    public static int dfs(int idx, int count) {
        visited[idx] = true;

        if (map.getOrDefault(idx, null) == null) {
            return 1;
        }
        for (int e : map.get(idx)) {
            if (!visited[e]) {
                visited[e] = true;
                dfs(e, count + 1);
                visited[e] = false;
            }
        }
        max = Math.max(max, count);
        return max;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            max = 0;

            for (int j = 0; j < m; j++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map.computeIfAbsent(arr[0], k -> new ArrayList<>()).add(arr[1]);
                map.computeIfAbsent(arr[1], k -> new ArrayList<>()).add(arr[0]);
            }
            for (int j = 1; j < n + 1; j++) {
                visited = new boolean[n + 1];
                dfs(j, 1);
            }
            System.out.println("#" + i + " " + max);
        }
    }
}
