package Programmers_lev2.June26;

import java.util.Arrays;

public class lifeboat {
    public static void main(String[] args) {
        int[] arr1 = {100, 90, 10, 50,50};
        int[] arr2 = {40, 40, 35, 50, 60, 60, 75, 70, 80, 90};
        System.out.println(Solution626_2.solution(arr1, 100));
        System.out.println(Solution626_2.solution(arr2, 200));
    }
}

class Solution626_2 {
    public static int solution(int[] people, int limit) {
        int count = 0;

        Arrays.sort(people);
        int a = 0;
        int b = people.length - 1;

        while (a <= b) {
            if (people[a] + people[b] <= limit) {
                a++;
            }
            b--;
            count++;
        }
        return count;
    }    
}

// class Solution626_2 {
//     public static boolean checkClear(boolean[] visited) {
//         for (var e : visited) {
//             if (!e) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public static int solution(int[] people, int limit) {
//         int count = 0;
//         boolean[] visited = new boolean[people.length];

//         Integer[] integerArr = Arrays.stream(people).boxed().toArray(Integer[]::new);
//         Arrays.sort(integerArr, Comparator.reverseOrder());

//         for (int i = 0; i < integerArr.length; i++) {
//             int sum = integerArr[i];
//             if (!visited[i]) {
//                 for (int j = i + 1; j < integerArr.length; j++) {
//                     if (!visited[j] && sum + integerArr[j] <= limit) {
//                         sum += integerArr[j];
//                         visited[j] = true;
//                     }
//                 }
//             }
//             visited[i] = true;
//             count++;
//             if (checkClear(visited)) {
//                 return count;
//             }
//         }
//         return count;
//     }    
// }
