import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * chessMovingCnt = 체스의 총 움직임을 담는다.
 */

class Point {
    int x;
    int y;
    int cnt;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int[] x = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            int chessLength = Integer.parseInt(br.readLine());

            Point[] points = new Point[2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                points[i] = new Point(start, end);
            }
            sb.append(bfs(points, chessLength) + "\n");

        }
        System.out.println(sb);

    }

    public static int bfs(Point[] points, int chessLength) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(points[0]);

        boolean[][] visited = new boolean[chessLength][chessLength];
        visited[points[0].x][points[0].y] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            if (poll.x == points[1].x && poll.y == points[1].y) {
                return poll.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int dx = poll.x + x[i];
                int dy = poll.y + y[i];

                if (dx < 0 || dy < 0 || dx >= chessLength || dy >= chessLength) {
                    continue;
                }
                if (!visited[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.offer(new Point(dx, dy, poll.cnt + 1));
                }

            }

        }
        return 0;
    }
}
