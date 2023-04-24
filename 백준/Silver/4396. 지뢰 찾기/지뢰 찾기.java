import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] bomb = new char[n][n];
        char[][] map = new char[n][n];
        // 8방 탐색
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

        // 지뢰를 열었을 때, 폭탄이 있었는지를 나타내는 변수 (초기값 1로 설정한 후, 폭탄이 있다면 0으로 바꿈)
        int boom = 1;

        // 지뢰 위치 입력 받기
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                bomb[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'x') { // 지뢰를 열었을 때
                    if (bomb[i][j] == '*') { // 출력시 지뢰 부분을 *로 바꾸기 위한 표시
                        boom = 0;
                    } else { // 지뢰를 열지 않았을 때
                        int count = 0;
                        for (int k = 0; k < 8; k++) { // 해당 칸을 둘러싼 8칸 검사
                            int new_x = i + x[k];
                            int new_y = j + y[k];
                            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && bomb[new_x][new_y] == '*') // 둘러싼 칸에서 지뢰 있으면 count 1 증가
                                count++;
                        }
                        map[i][j] = (char) (count + '0'); // 문자형으로 변화해주기 위해 '0'을 더함
                    }
                } else {
                    map[i][j] = '.';
                }
            }
        }


        if (boom == 0) { // 지뢰 열었을 경우 지뢰 부분 *로 바꾸기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb[i][j] == '*')
                        map[i][j] = '*';
                }
            }
        }

        // 전체 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
    }
}