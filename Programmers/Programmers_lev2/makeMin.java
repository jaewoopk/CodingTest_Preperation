package Programmers_lev2;

import java.util.Arrays;

public class makeMin extends Solution{
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        System.out.println(solution1(A,B));
    }
}

// make min문제에 대한 로직
// 1. 부여받은 int 배열 A와 B를 sort해준다.
// 2. A는 차례대로, B는 역순으로 곱해줘서 해결한다.
//
// 처음에는 백트래킹을 써서 풀어볼까도 했지만, 접근하는 방법이 잘못되어서 그런지 어려웠다.
// 앞으로는 문제를 보고 최대한 쉬운 방법으로 풀 수는 없을까를 계속 고민해보자.
// 문제가 요구하는 바가 무엇인지 명확히 캐치하고 쉽게쉽게 풀어보자.

class Solution {
    public static int solution1(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[A.length - i - 1]);
        }
        return answer;
    }
}
