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
        int[] output = new int[N]; //n개 뽑음 -> nPn -> n!
        boolean[] visited = new boolean[N];


        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
//        System.out.println("arr = " + Arrays.toString(arr));
        perm(arr, output, visited, 0, N, M);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int N, int M) {
        if (depth == M) {
            print(output, M);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, N, M);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
