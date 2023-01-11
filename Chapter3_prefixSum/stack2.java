package Chapter3_prefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
        
        for (int i = 0; i < n; i++){
            bw.write(arr[i] + " ");
        }
        bw.close();
    }
}

// public class stack2 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         Stack<Integer> leftStack = new Stack<>();
//         Stack<Integer> middleStack = new Stack<>();
//         Stack<Integer> rightStack = new Stack<>();
//         Stack<Integer> answerStack = new Stack<>();

//         int n = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             leftStack.push(Integer.parseInt(st.nextToken()));
//         }
//         middleStack.push(0);
//         rightStack.push(leftStack.pop());
//         answerStack.push(-1);

//         while (!leftStack.isEmpty()) {
//             if (rightStack.peek() > leftStack.peek()) {
//                 if (middleStack.peek() <= leftStack.peek()) {
//                     middleStack.push(leftStack.peek());
//                     answerStack.push(rightStack.peek());
//                 }
//                 else {
//                     answerStack.add(middleStack.peek());    
//                 }
//                 leftStack.pop();
//             }
//             else {
//                 rightStack.push(leftStack.pop());
//                 answerStack.push(-1);
//             }
//         }

//         for (int i = 0; i < n; i++){
//             bw.write(answerStack.pop() + " ");
//         }
//         bw.close();
//     }
// }
