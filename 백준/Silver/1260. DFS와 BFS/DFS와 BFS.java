import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS = stack
 * BFS = queue
 */
public class Main {
    boolean[] visited;
    static int[][] arr;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder bfs = new StringBuilder();
        StringBuilder dfs = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

//        System.out.println("N = " + N + ", M = " + M + ", V = " + V);


        arr = new int[M][2];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
//        System.out.println("arr = " + Arrays.deepToString(arr));

        ArrayList<Integer>[] newArr = new ArrayList[N + 1];

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i][0];
            int value = arr[i][1];

            if (newArr[index] == null) {
                newArr[index] = new ArrayList<>();
            }

            if (newArr[value] == null) {
                newArr[value] = new ArrayList<>();
            }

            newArr[index].add(value);
            newArr[value].add(index);
        }
//        System.out.println("newArr = " + Arrays.toString(newArr));

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        stack.push(V);

        while (!stack.isEmpty()) {
            Integer firstStack = stack.pop();
            if (!visited[firstStack]) {
                visited[firstStack] = true;
                dfs.append(firstStack).append(" ");

                ArrayList<Integer> stacks = newArr[firstStack];

                if (stacks == null) {
                    continue;
                }
                // 정점 번호가 작은 것을 먼저 방문
                stacks.sort(Collections.reverseOrder());

                for (int i = 0; i < stacks.size(); i++) {
                    stack.push(stacks.get(i));

                }
            }
        }

        System.out.println(dfs);

        visited = new boolean[N + 1];
        queue.add(V);
        while (!queue.isEmpty()) {
            Integer firstQueue = queue.poll();
            if (!visited[firstQueue]) {
                visited[firstQueue] = true;
                bfs.append(firstQueue).append(" ");
                ArrayList<Integer> queues = newArr[firstQueue];

                if (queues == null) {
                    continue;
                }
                // 정점 번호가 작은 것을 먼저 방문하도록 정렬
                Collections.sort(queues);

                for (int i = 0; i < queues.size(); i++) {
                    queue.add(queues.get(i));

                }
            }
        }
        System.out.println(bfs);
    }
}
