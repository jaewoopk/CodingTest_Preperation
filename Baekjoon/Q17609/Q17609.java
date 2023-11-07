package Baekjoon.Q17609;

import java.util.*;
import java.io.*;

public class Q17609 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int len = str.length();
            StringBuffer sb = new StringBuffer(str.substring(len / 2, len));
            String cmpStr = sb.reverse().toString();

            if (cmpStr.equals(str.substring(0, len / 2))) {
                System.out.println(0);
            } else {
                boolean check = false;
                for (int j = 0; j < str.length() / 2; j++) {
                    String newStr = str.substring(0, j).concat(str.substring(j + 1, str.length()));
                    String newStr2 = str.substring(0, str.length() - j - 1).concat(str.substring(str.length() - j, str.length()));
                    //System.out.println(newStr);
                    sb = new StringBuffer(newStr.substring(len / 2, len - 1));
                    StringBuffer sb2 = new StringBuffer(newStr2.substring(len / 2, len - 1));
                    cmpStr = sb.reverse().toString();
                    String cmpStr2 = sb2.reverse().toString();

                    if (cmpStr.equals(newStr.substring(0, len / 2)) || cmpStr2.equals(newStr2.substring(0, len / 2))) {
                        System.out.println(1);
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    System.out.println(2);
                }
            }
        }
    }
}

//7
//        abba
//        summuus
//        xabba
//        xabbay
//        comcom
//        comwwmoc
//        comwwtmoc