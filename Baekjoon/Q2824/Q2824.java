package Baekjoon.Q2824;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Q2824 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger("1");
        for (int i = 0; i < n; i++) {
            A = A.multiply(new BigInteger(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        BigInteger B = new BigInteger("1");
        for (int i = 0; i < m; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }

        A = A.gcd(B);
        String str = A.toString();

        if (str.length() > 9) {
            str = str.substring(str.length() - 9, str.length());
        }
        System.out.println(str);
    }
}
