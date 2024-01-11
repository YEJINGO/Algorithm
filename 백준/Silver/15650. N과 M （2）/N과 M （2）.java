
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        boolean[] visited = new boolean[N];
        comb(arr, visited, 0, N, M);
    }

    static void comb(int[] arr, boolean[] visited, int depth, int N, int M) {
        if (M == 0) {
            print(arr, visited, N);
            return;
        }

        if (depth == N) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, N, M - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, N, M);
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int r) {
        for (int i = 0; i < r; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
