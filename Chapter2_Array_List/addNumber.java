package Chapter2_Data_Structure;

import java.util.Scanner;

public class addNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = sc.next();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (int)((num.charAt(i)) - '0');
        }
        System.out.println(sum);
        sc.close();
    }
}
