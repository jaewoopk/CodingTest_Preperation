package Chapter3_Data_Structure;

import java.util.*;

public class stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<Integer>();

        int n = sc.nextInt();
        int srcNum = 1;
        boolean isRight = true;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            while (srcNum <= num) {
                s.push(srcNum++);
                sb.append("+\n");
            }
            if (s.peek() == num) {
                s.pop();
                sb.append("-\n");
            }
            else {
                isRight = false;
            }
        }

        if (!isRight) {
            System.out.println("NO");
            sc.close();
            return ;
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
