package SWEA.D2.Q1926;

import java.util.*;

public class Q1926 {
    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            boolean checker = false;
            if (test_case % 10 == 3 || test_case % 10 == 6 || test_case % 10 == 9) {
                checker = true;
                sb.append("-");
            }
            if (test_case / 10 == 3 || test_case / 10 == 6 || test_case / 10 == 9) {
                checker = true;
                sb.append("-");
            }
            if (test_case / 100 == 3 || test_case / 100 == 6 || test_case / 100 == 9) {
                checker = true;
                sb.append("-");
            }
            if (!checker) {
                sb.append(Integer.toString(test_case));
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
