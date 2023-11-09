package PCCP.PCCP2_1;

public class PCCP2_1 {
    public int[] solution(String command) {
        int x = 0;
        int y = 0;
        int check = 0;
        String[] strSplit = command.split("");
        boolean[] directions = new boolean[4];

        for (String e : strSplit) {
            if (e.equals("R")) {
                check = (check + 1) % 4;
            } else if (e.equals("L")) {
                if (check <= 0) {
                    check += 4;
                }
                check = (check - 1) % 4;
            } else if (e.equals("G")) {
                switch(check % 4) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x--;
                        break;
                }
            } else if (e.equals("B")) {
                switch(check % 4) {
                    case 0:
                        y--;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y++;
                        break;
                    case 3:
                        x++;
                        break;
                }
            }
        }
        return new int[] {x, y};
    }
}
