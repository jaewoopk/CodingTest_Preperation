package Chapter3_Data_Structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class slidingWindow2 {
    static int n, m;
    static Deque<Node> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            int data = Integer.parseInt(st.nextToken());
            bw.write(findMin(new Node(i, data), i) + " ");
        }
        bw.close();
    }
    private static int findMin(Node node, int i) {
        while (!dq.isEmpty() && dq.getLast().value > node.value) {
            dq.removeLast();
        }
        dq.addLast(node);
        if (dq.getFirst().idx <= i - m) {
            dq.removeFirst();
        }

        return dq.getFirst().value;
    }

    static class Node {
        public int idx;
        public int value;

        Node(int _idx, int _value) {
            this.idx = _idx;
            this.value = _value;
        }
    }
}

// public class slidingWindow2 {
//     static int n, m;
//     static int[] arr;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
        
//         st = new StringTokenizer(br.readLine());
//         arr = new int[n + m - 1];

//         for (int i = 0; i < m - 1; i++) {
//             arr[i] = Integer.MAX_VALUE;
//         } 
//         for (int i = m - 1; i < n + m - 1; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//         }

//         for (int i = 0; i < n; i++) {
//             int min = Integer.MAX_VALUE;
//             for (int j = 0; j < m; j++) {
//                 if (min > arr[i + j]) {
//                     min = arr[i + j];
//                 }
//             }
//             System.out.print(min + " ");
//         }
//     }
// }
