import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    boolean[] visited;
    static int[][] arr;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

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

        ArrayList<Integer> dfs_result = new ArrayList<>();
        ArrayList<Integer> bfs_result = new ArrayList<>();

        stack.push(V);

        while (!stack.isEmpty()) {
            Integer firstStack = stack.pop();
            if (!visited[firstStack]) {
                visited[firstStack] = true;
                dfs_result.add(firstStack);
                ArrayList<Integer> stacks = newArr[firstStack];

                if (stacks == null) {
                    continue;
                }
                stacks.sort(Collections.reverseOrder());

                for (int i = 0; i < stacks.size(); i++) {
                    stack.push(stacks.get(i));

                }
            }
        }

//        System.out.println("dfs_result = " + dfs_result);
//        System.out.println(dfs_result);
        for (int i = 0; i < dfs_result.size(); i++) {
            System.out.print(dfs_result.get(i));
            if (i < dfs_result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        visited = new boolean[N + 1];
        queue.add(V);
        while (!queue.isEmpty()) {
            Integer firstQueue = queue.poll();
            if (!visited[firstQueue]) {
                visited[firstQueue] = true;
                bfs_result.add(firstQueue);
                ArrayList<Integer> queues = newArr[firstQueue];

                if (queues == null) {
                    continue;
                }
                Collections.sort(queues);

                for (int i = 0; i < queues.size(); i++) {
                    queue.add(queues.get(i));

                }
            }
        }
//        System.out.println("bfs_result = " + bfs_result);
//        System.out.println(bfs_result);
        for (int i = 0; i < bfs_result.size(); i++) {
            System.out.print(bfs_result.get(i));
            if (i < bfs_result.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}