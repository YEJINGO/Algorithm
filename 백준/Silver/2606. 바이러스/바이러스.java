import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int count = -1;
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        arr = new int[M][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

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
        stack.push(1);

        while (!stack.isEmpty()) {
            Integer com = stack.pop();
            visited[com] = true;
            ArrayList<Integer> coms = newArr[com];

            if (coms == null) {
                continue;
            }


            for (int i = 0; i < coms.size(); i++) {
                if (!(stack.contains(coms.get(i)) || visited[coms.get(i)])) {
                    stack.push(coms.get(i));
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
}
