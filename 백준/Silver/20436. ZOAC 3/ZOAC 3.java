import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(" ");
        String s = br.readLine();
        int min = 0;

        Map<String, Coor> leftKeyboard = new HashMap<>();
        leftKeyboard.put("q", new Coor(1, 1));
        leftKeyboard.put("w", new Coor(1, 2));
        leftKeyboard.put("e", new Coor(1, 3));
        leftKeyboard.put("r", new Coor(1, 4));
        leftKeyboard.put("t", new Coor(1, 5));
        leftKeyboard.put("a", new Coor(2, 1));
        leftKeyboard.put("s", new Coor(2, 2));
        leftKeyboard.put("d", new Coor(2, 3));
        leftKeyboard.put("f", new Coor(2, 4));
        leftKeyboard.put("g", new Coor(2, 5));
        leftKeyboard.put("z", new Coor(3, 1));
        leftKeyboard.put("x", new Coor(3, 2));
        leftKeyboard.put("c", new Coor(3, 3));
        leftKeyboard.put("v", new Coor(3, 4));

        Map<String, Coor> rightKeyboard = new HashMap<>();
        rightKeyboard.put("y", new Coor(1, 6));
        rightKeyboard.put("u", new Coor(1, 7));
        rightKeyboard.put("i", new Coor(1, 8));
        rightKeyboard.put("o", new Coor(1, 9));
        rightKeyboard.put("p", new Coor(1, 10));
        rightKeyboard.put("h", new Coor(2, 6));
        rightKeyboard.put("j", new Coor(2, 7));
        rightKeyboard.put("k", new Coor(2, 8));
        rightKeyboard.put("l", new Coor(2, 9));
        rightKeyboard.put("b", new Coor(3, 5));
        rightKeyboard.put("n", new Coor(3, 6));
        rightKeyboard.put("m", new Coor(3, 7));

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (rightKeyboard.containsKey(c)) {
                Coor coor1 = rightKeyboard.get(c);// c의 좌표 뽑기
                Coor coor2 = rightKeyboard.get(String.valueOf(start[1]));
                int rightTime = Math.abs(coor1.a - coor2.a) + Math.abs(coor1.b - coor2.b) + 1;
                min += rightTime;
                start[1] = c;
            } else {
                Coor coor1 = leftKeyboard.get(c);// c의 좌표 뽑기
                Coor coor2 = leftKeyboard.get(start[0]);
                int leftTime = Math.abs(coor1.a - coor2.a) + Math.abs(coor1.b - coor2.b) + 1;
                min += leftTime;
                start[0] = c;
            }

        }
        System.out.println(min);
    }

    static class Coor { // 인덱스 값
        int a = 0;
        int b = 0;

        Coor(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }
}