package Chapter1_How_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

// It's correct but this isn't the best way

public class reorderingNumber {
    public static void selectSort(ArrayList<Integer> _arr,int _n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(_arr.get(0));
        for (int i = 1; i < _n; i++) {
            for (int j = 0; j < i; j++) {
                if (answer.get(j) > _arr.get(i)) {
                    answer.add(j, _arr.get(i));
                    break ;
                }
                else if (j == i - 1) {
                    answer.add(_arr.get(i));
                }
            }
        }
        for (int i = 0; i < _n; i++) {
            System.out.println(answer.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        selectSort(arr, n);
        sc.close();
    }
}
