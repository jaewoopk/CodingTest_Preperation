package TestProgrammers;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
                break ;
            }
        }
        answer = "김서방은 " + Integer.toString(idx) + "에 있다";
        answer = Integer.toString(idx);
        return answer;   
    }
}