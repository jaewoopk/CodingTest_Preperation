package Chapter5_Search;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BFS3 {

    static int n;
    static int result = 0;
    static int max_node = 0;
    static ArrayList<Edge>[] nodes;

    static class Edge{ // 트리(그래프) 저장용
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node{ // BFS 탐색용
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            int idx = Integer.parseInt(inputs[0]);
            int j = 1;
            while(true){
                int v_num = Integer.parseInt(inputs[j]);
                if(v_num == -1) break;
                int weight = Integer.parseInt(inputs[j+1]);

                nodes[idx].add(new Edge(v_num, weight));

                j += 2;
            }
        }

        bfs(1); // 임의의 노드 1
        bfs(max_node); // 임의의 노드 1에서 가장 먼 노드부터 bfs 시작

        System.out.println(result);

    }


    public static void bfs(int start) {

        boolean[] visited = new boolean[n + 1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        int max_cnt = 0;

        while (!q.isEmpty()) {
            Node p = q.poll();

            if(p.cnt>max_cnt){
                max_cnt = p.cnt;	// 가장 멀리 떨어진 노드의 거리
                max_node = p.idx;	// 가장 멀리 떨어진 노드의 번호
            }

            for (Edge e : nodes[p.idx]) {
                if(!visited[e.end]){
                    visited[e.end] = true;
                    q.add(new Node(e.end, p.cnt + e.weight));

                }
            }

        }

        result = Math.max(result, max_cnt);

    }
}


// public class BFS3 {
//     static LinkedList<Node>[] arr;
//     static Queue<Node> queue;
//     static boolean visited[];
//     static int distance[];
//     static long max;

//     static void bfs3(int i) {
//         Node beforeNode = arr[i].peek();
//         queue.add(beforeNode);
//         visited[beforeNode.e] = true;

//         while(!queue.isEmpty()) {
//             Node p = queue.poll();
//             for (var node : arr[p.e]) {
//                 if (!visited[node.e]) {
//                     queue.add(node);
//                     int edge = node.e;
//                     distance[edge] += (distance[p.e] + node.r);
//                     visited[node.e] = true;
//                     if (max < distance[edge]) {
//                         max = distance[edge];
//                     }
//                 }
//             }
//         }
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         LinkedList<Integer> nrr = new LinkedList<Integer>();

//         int n;
//         n = Integer.parseInt(st.nextToken());
//         arr = new LinkedList[n + 1];
//         visited = new boolean[n + 1];
//         distance = new int[n + 1];
//         queue = new LinkedList<>();

//         for (int i = 1; i < n + 1; i++) {
//             visited[i] = false;
//             st = new StringTokenizer(br.readLine());
//             int num;
//             num = Integer.parseInt(st.nextToken());
//             arr[num] = new LinkedList<>();
//             while (true) {
//                 int e, r;
//                 e = Integer.parseInt(st.nextToken());
//                 if (e == -1) {
//                     break ;
//                 }
//                 r = Integer.parseInt(st.nextToken());

//                 Node newNode = new Node(e, r);
//                 arr[num].add(newNode);
//             }
//             nrr.add(num);
//         }
//         bfs3(1);
//         System.out.println(max);
//     }
//     static class Node {
//         int e;
//         int r;
//         Node(int e, int r) {
//             this.e = e;
//             this.r = r;
//         }
//     }
// }

