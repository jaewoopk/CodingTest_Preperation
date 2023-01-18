package Chapter5_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static Queue<Integer> queue;

    static void bfs(int idx) {
        visited[idx] = true;
        queue.add(idx);

        int i = 0;
        while (i < arr[idx].size() - 1 && !queue.isEmpty()) {
            int p = queue.poll();
            System.out.print(" " + p);
            if (!visited[arr[p].get(i)]) {
                visited[arr[p].get(i)] = true;
                queue.add(arr[p].get(i));
                bfs(arr[p].get(i));
            }
            i++;
        }
        visited[idx] = false;
    }

    static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(" " + idx);
        for (int i = 0; i < arr[idx].size(); i++) {
            if (visited[arr[idx].get(i)] == true) {
                continue ;
            }
            dfs(arr[idx].get(i));
        }

        visited[idx] = false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[m];
        queue = new LinkedList<Integer>();
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
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
        dfs(k);
        System.out.println();
        //bfs(k);
    }
}
