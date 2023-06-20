package Programmers_lev2.June20;

public class nextBigNumber {
    public static void main(String[] args) {
        System.out.println(Solution620_2.solution(78));
        System.out.println(Solution620_2.solution(15));
    }
}

class Solution620_2 {
    public static int countOne(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    public static int solution(int n) {
        String ans = Integer.toBinaryString(n);
        int ansCount = countOne(ans);
        for (int i = n + 1; i <= 1000000; i++) {
            String str = Integer.toBinaryString(i);
            int strCount = countOne(str);
            if (ansCount == strCount) {
                return i;
            }
        }
        return 0;
    }
}


// class TryHelloWorld
// {
//     public int nextBigNumber(int n)
//     {
//       int a = Integer.bitCount(n);
//       int compare = n+1;
//       while(true) {
//         if(Integer.bitCount(compare)==a)
//           break;
//         compare++;
//       }
//       return compare;
//     }
//     public static void main(String[] args)
//     {
//         TryHelloWorld test = new TryHelloWorld();
//         int n = 78;
//         System.out.println(test.nextBigNumber(n));
//     }
// }
// Integer.bitCount() 메서드를 통해 2진법으로 치환했을 때의 1의 개수를 구할 수 있다.