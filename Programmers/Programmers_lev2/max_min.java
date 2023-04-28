package Programmers_lev2;

public class max_min extends Solution{
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
    }
}

// max min문제에 대한 로직
// 1. s로 받은 String에 대한 문자열 자르기 -> s.split(" ")를 통해 띄어쓰기를 기준으로 문자열 분리 가능
// 2. 문제를 풀 때는 Integer.valueOf(string)을 통해 해결했지만 Integer.parseInt(string)을 통해 더 쉽게 풀 수 있음
//         String[] array = str.split(" ");
//         int[] arrayInt = new int[array.length];

//         for (int i = 0; i < arrayInt.length; i++) {
//             arrayInt[i] = Integer.parseInt(array[i]);
//         }

// 3. 여기에 Arrays.sort() 를 통해 최대값과 최소값을 쉽게 구할 수도 있다.
// 4. 또한, 문자열은 정수 + 문자열 + 정수를 문자열로 반환할 수도 있으므로 쉽게 표현할 수 있다.
//
//
//



class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (var e : arr) {
            int value = Integer.valueOf(e);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        answer += Integer.toString(min);
        answer += " ";
        answer += Integer.toString(max);

        return answer;
    }
}

// import java.util.Arrays;

// public class GetMinMaxString {
//     public String getMinMaxString(String str) {

//         String[] array = str.split(" ");
//         int[] arrayInt = new int[array.length];

//         for (int i = 0; i < arrayInt.length; i++) {
//             arrayInt[i] = Integer.parseInt(array[i]);
//         }

//         Arrays.sort(arrayInt);
//         String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];

//         return result;

//     }

//     public static void main(String[] args) {
//         String str = "9 19";
//         GetMinMaxString minMax = new GetMinMaxString();
//         // 아래는 테스트로 출력해 보기 위한 코드입니다.
//         System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
//     }
// }