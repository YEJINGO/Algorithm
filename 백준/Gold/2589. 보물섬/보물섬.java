import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class TreasureIslandInfo {
    int x;
    int y;
    int cnt;

    public TreasureIslandInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public TreasureIslandInfo(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}


public class Main {
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행과 열 입력 받기
        StringTokenizer dimensions = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(dimensions.nextToken()); // 행
        int m = Integer.parseInt(dimensions.nextToken()); // 열
//        boolean[][] visited = new boolean[n][m];
        Queue<TreasureIslandInfo> queue = new LinkedList<>();
        int returnMax = 0;

        // 2차원 배열 생성
        char[][] map = new char[n][m];

        // 입력값을 배열에 저장
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }
//        System.out.println("map = " + Arrays.deepToString(map));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = map[i][j];
                if (c == 'L') {
                    boolean[][] visited = new boolean[n][m];

                    queue.offer(new TreasureIslandInfo(i, j, 0));
                    visited[i][j] = true;

                    int result = bfs(queue, visited, map, n, m);
                    returnMax = Math.max(returnMax, result);
                }
            }
        }
        System.out.println(returnMax);
    }

    public static int bfs(Queue<TreasureIslandInfo> queue, boolean[][] visited, char[][] map, int n, int m) {

        int maxDay = 0;
        while (!queue.isEmpty()) {
            TreasureIslandInfo current = queue.poll();
            maxDay = Math.max(maxDay, current.cnt);

            for (int i = 0; i < 4; i++) {
                int dx = current.x + x[i];
                int dy = current.y + y[i];

                if (dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] != 'W'&& !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.offer(new TreasureIslandInfo(dx, dy, current.cnt + 1));
                }
            }

        }
        return maxDay;

    }
}