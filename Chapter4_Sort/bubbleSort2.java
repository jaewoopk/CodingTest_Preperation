package Chapter4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bubbleSort2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        mData[] arr = new mData[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);

    }
}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}

// public class bubbleSort2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         int n = sc.nextInt();
//         int[] arr = new int[n + 1];
//         int countIdx = 1;

//         for (int i = 1; i < n + 1; i++) {
//             arr[i] = sc.nextInt();
//             pq.add(arr[i]);
//         }

//         for (int i = 1; i < n + 1; i++) {
//             if (pq.peek() == arr[i]) {
//                 countIdx++;
//                 pq.poll();
//             }
//         }
//         System.out.println(n - countIdx + 2);

//         sc.close();
//     }
// }
