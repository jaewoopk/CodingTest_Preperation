package Programmers_lev2.phonebook;

import java.util.Arrays;

public class phonebook {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(Solution.solution(new String[]{"123", "456", "789"}));
    }
}

class Solution {
    public static boolean solution(String[] phone_book) {
        // 전화번호를 정렬
        Arrays.sort(phone_book);

        // 인접한 전화번호만을 검사하여 접두사 관계 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }


}

//
//class TrieNode {
//    TrieNode[] children;
//    boolean isEndOfWord;
//
//    TrieNode() {
//        children = new TrieNode[10];
//        isEndOfWord = false;
//    }
//}
//
//public class Solution {
//
//    private static TrieNode root = new TrieNode();
//
//    private static boolean insert(String phone) {
//        TrieNode node = root;
//        for (char c : phone.toCharArray()) {
//            int index = c - '0';
//            if (node.children[index] == null) {
//                node.children[index] = new TrieNode();
//            }
//            node = node.children[index];
//
//            if (node.isEndOfWord) return false; // 현재 번호가 이미 있는 번호의 접두사
//        }
//        node.isEndOfWord = true;
//
//        for (TrieNode child : node.children) {
//            if (child != null) return false; // 이미 있는 번호가 현재 번호의 접두사
//        }
//
//        return true;
//    }
//
//    public static boolean solution(String[] phone_book) {
//        for (String phone : phone_book) {
//            if (!insert(phone)) return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); // false
//        System.out.println(solution(new String[]{"123", "456", "789"})); // true
//        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"})); // false
//    }
//}
