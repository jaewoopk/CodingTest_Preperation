package Programmers_lev2;

public class againBinary extends Solution6{
    public static void main(String[] args) {
        System.out.println(solution6("110010101001")[0]);
        System.out.println(solution6("110010101001")[1]);
    }
}

// againBinary 문제에 대한 로직
// 나의 풀이
// 1. 문자열에 포함된 "1"을 새로운 문자열에 더해주고, "0"이 나올경우 count 증가
// 2. makingBinary라는 함수를 만들어, 해당 문자열의 길이를 이진법으로 나타낸 문자열로 바꿈
// 3. 다시 돌아가서 반복
// 
// 다른 풀이
// 1. s.equals("1")이 아닐 때,
// 2. s = s.replaceAll("0","")
// 3. s = Integer.toBinaryString(십진수)
// 4. 반복

class Solution6 {
    public static int[] solution6(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
    }
}

// class Solution6 {
//     public static boolean flag = true;
//     public static int[] solution6(String s) {
//         int[] answer = new int[2];
//         String[] str = s.split("");
//         int turn = 0, count = 0;
//         while (true) {
//             String tmp = new String();
//             for (var e : str) {
//                 if (e.equals("1")) {
//                     tmp += e;
//                 }
//                 else {
//                     count++;
//                 }
//             }
//             str = makingBinary(tmp).split("");
//             turn++;
//             if (str.length == 1) {
//                 break ;
//             }
//             flag = true;
//         }
//         answer[0] = turn;
//         answer[1] = count;
//         return answer;
//     }

//     public static String makingBinary(String s) {
//         int len = s.length();
//         int cmp = 1;
//         while (len / 2 >= cmp) {
//             cmp *= 2;
//         }
//         String tmp = new String();
//         while (cmp > 0) {
//             if (len / cmp == 1) {
//                 tmp += "1";
//             }
//             else {
//                 tmp += "0";
//             }
//             len %= cmp;
//             cmp /= 2;
//         }
//         return tmp;
//     }
// }
