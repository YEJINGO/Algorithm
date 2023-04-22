import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(extracted(br));


    }

    private static int extracted(BufferedReader br) throws IOException {
        int[][] bingo = new int[5][5];
        Map<String, Coo> bingoMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(arr[j]);
                bingoMap.put(arr[j], new Coo(i, j));
            }
//            System.out.println(Arrays.toString(bingo[i]));
        }

        for (int i = 0; i < 5; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                Coo c = bingoMap.get(arr[j]);
                bingo[c.i][c.j] = 0;
                int cnt = 0;
                // 빙고 체크 시작
                for (int k = 0; k < 5; k++) {
                    if (Arrays.stream(bingo[k]).max().getAsInt() == 0) {
                        cnt++;
                    }
                    if (bingo[0][k] + bingo[1][k] + bingo[2][k] + bingo[3][k] + bingo[4][k] == 0) {
                        cnt++;
                    }
                }
                if (bingo[0][0] + bingo[1][1] + bingo[2][2] + bingo[3][3] + bingo[4][4] == 0) {
                    cnt++;
                }
                if (bingo[0][4] + bingo[1][3] + bingo[2][2] + bingo[3][1] + bingo[4][0] == 0) {
                    cnt++;
                }
                if (cnt >= 3) {
                    return (5 * i) + (j+1);
                }
            }
        }
        return 1;
    }

    static class Coo {
        int i = 0;
        int j = 0;

        Coo(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }
}
