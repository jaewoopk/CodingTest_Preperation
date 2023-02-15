package SoftwareMaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q8 {
    static int n, m, v;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[n + 1];
        q = new LinkedList<Integer>();

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int s, e;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 1; i < n + 1; i++) {
            arr[i].sort(null);
        }
        visited = new boolean[n + 1];
        myDfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        myBfs(v);
    }

    static void myDfs(int num) {
        if (!visited[num]) {
            System.out.print(num + " ");
            visited[num] = true;
        }
        for (int i = 0; i < arr[num].size(); i++) {
            if (!visited[arr[num].get(i)]) {
                visited[arr[num].get(i)] = true;
                System.out.print(arr[num].get(i) + " ");
                myDfs(arr[num].get(i));
            }
        }
    }
    static void myBfs(int num) {
        if (!visited[num]) {
            q.add(num);
            System.out.print(num + " ");
            visited[num] = true;
        }

        while (!q.isEmpty()) {
            int pnum = q.poll();
            for (int i = 0; i < arr[pnum].size(); i++) {
                if (!visited[arr[pnum].get(i)]) {
                    visited[arr[pnum].get(i)] = true;
                    q.add(arr[pnum].get(i));
                    System.out.print(arr[pnum].get(i) + " ");
                }
            }
        }
    }
}
