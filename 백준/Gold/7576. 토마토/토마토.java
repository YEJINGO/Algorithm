import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class TomatoInfo {
    int x;
    int y;
    int cnt;

    public TomatoInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public TomatoInfo(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[height][width];
        Queue<TomatoInfo> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];


        // 초기 익은 토마토 위치를 큐에 넣기
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.offer(new TomatoInfo(i, j, 0));
                    visited[i][j] = true; // 초기 익은 토마토 위치 방문 처리
                }
            }
        }

        int result = bfs(queue, tomatoes, visited, width, height);

        // 결과 출력
        System.out.println(result);

    }

    public static int bfs(Queue<TomatoInfo> queue, int[][] tomatoes, boolean[][] visited, int width, int height) {

        int maxDay = 0;
        while (!queue.isEmpty()) {
            TomatoInfo current = queue.poll();
            maxDay = Math.max(maxDay, current.cnt);

            for (int i = 0; i < 4; i++) {
                int dx = current.x + x[i];
                int dy = current.y + y[i];

                if (dx >= 0 && dx < height && dy >= 0 && dy < width && tomatoes[dx][dy] == 0) {
                    tomatoes[dx][dy] = 1;
                    visited[dx][dy] = true;
                    queue.offer(new TomatoInfo(dx, dy, current.cnt + 1));
                }
            }
        }

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tomatoes[i][j] == 0) {
                    return -1; // 익지 않은 토마토가 남아있으면 -1 반환
                }
            }
        }

        return maxDay;
    }
}