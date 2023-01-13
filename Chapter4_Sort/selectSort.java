package Chapter4_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class selectSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] chArr = new char[str.length()];
        chArr = str.toCharArray();

        for (int i = 0; i < str.length() - 1; i++) {
            int max = (int)chArr[i];
            int idx = i;
            for (int j = i + 1; j < str.length(); j++) {
                if ((int)chArr[j] > max) {
                    max = (int)chArr[j];
                    idx = j;
                }
            }
            
            char tmp = chArr[i];
            chArr[i] = chArr[idx];
            chArr[idx] = tmp;
        }

        for (var e : chArr) {
            System.out.print(e);
        }
    }
}
