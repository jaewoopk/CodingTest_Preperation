package Chapter6_Greedy;

import java.util.Scanner;

public class greedy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String example = sc.nextLine();
        String[] str = example.split("-");
        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            int tmp = findSum(str[i]);

            if (i == 0) {
                answer += tmp;
            }
            else {
                answer -= tmp;
            }
        }
        System.out.println(answer);
        
        sc.close();
    }

    static int findSum(String a) {
        int sum = 0;
        String[] tmp = a.split("[+]");

        for (int i = 0; i < tmp.length; i++) {
            sum += Integer.parseInt(tmp[i]);
        }
        return sum;
    }
}

// public class greedy5 { // 로직은 틀리지 않는 것 같은데 정답이 아니다.
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         char[] charr = new char[50];
//         int[] inarr = new int[50];
//         int chidx = 0;
//         int inidx = 0;
//         String str = sc.nextLine();
//         int t = 0;
//         for (int i = 0; i < str.length(); i++) {

//             if (str.charAt(i) == '+') {
//                 inarr[inidx++] = t;
//                 charr[chidx++] = '+';
//                 t = 0;
//             }
//             else if (str.charAt(i) == '-') {
//                 inarr[inidx++] = t;
//                 charr[chidx++] = '-';
//                 t = 0;
//             }
//             else {
//                 t += (int)(str.charAt(i) - '0');
//                 if (i < str.length() - 1 && str.charAt(i + 1) != '+' && str.charAt(i + 1) != '-') {
//                     t *= 10;
//                 }
//             }
//         }
//         inarr[inidx++] = t;

//         for (int i = 0; i < chidx; i++) {
//             if (charr[i] == '+') {
//                 inarr[i + 1] += inarr[i]; 
//                 inarr[i] = -1;
//             }
//         }

//         t = 0;
//         for (int i = 0; i < inidx; i++) {
//             if (inarr[i] != -1 && t == 0) {
//                 t = inarr[i];
//             }
//             else if (inarr[i] != -1) {
//                 t -= inarr[i];
//             }
//         }
//         System.out.println(t);
//         sc.close();
//     }
// }
