package Chapter5_Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS {
    static boolean[] visit;
    static void dfs(int i, ArrayList<Integer>[] list) {
        visit[i] = true;
        for (var e : list[i]) {
            if (!visit[e]) {
                dfs(e, list);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        int count = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        boolean check = true;
        visit = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int v1, v2;
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        while (check) {
            check = false;
            int i;
            for (i = 1; i < n + 1; i++) {
                if (visit[i] == false) {
                    check = true;
                    break ;
                }
            }
            if (!check) {
                break ;
            }
            dfs(i, list);
            count++;
        }  
        System.out.println(count);

        bw.close();
    }
}
