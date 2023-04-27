package Chapter5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS3 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static void dfs3(int idx, int count) {
        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }
        visited[idx] = true;

        for (int i = 0; i < arr[idx].size(); i++) {
            if (visited[arr[idx].get(i)] == true) {
                continue ;
            }
            dfs3(arr[idx].get(i), count + 1);
        }
        visited[idx] = false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int v, e;
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr[v].add(e);
            arr[e].add(v);
        }

        for (int i = 0 ; i < n ; i ++) {
            dfs3(i, 1);
        }
        System.out.println(0);
    }
}
