package Programmers_lev2.June20;

public class expressionOfNumbers {
    public static void main(String[] args) {
        int n = 15;
        
        System.out.println(Solution620_1.solution(n));
        
    }
}

class Solution620_1 {
    public static int algo(int num, int n) {
        int total = 0;
        for (int i = num; i <= n; i++) {
            total += i;
            if (total == n) {
                return 1;
            }
            else if (total > n) {
                return 0;
            }
        }
        return 0;
    }
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += algo(i, n);
        }
        return answer;
    }
}


// public class Expressions {

//     public int expressions(int num) {
//         int answer = 0;
//    for (int i = 1; i <= num; i += 2) 
//        if (num % i == 0) 
//            answer++;

//    return answer;
//     }

//     public static void main(String args[]) {
//         Expressions expressions = new Expressions();
//         // 아래는 테스트로 출력해 보기 위한 코드입니다.
//         System.out.println(expressions.expressions(15));
//     }
// }
// 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다 라는 정수론 정리가 있다.