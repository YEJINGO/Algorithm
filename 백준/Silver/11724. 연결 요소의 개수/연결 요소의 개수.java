import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int N, M;

    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
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
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            arrayList.add(i);
        }

        while (!arrayList.isEmpty()) {
            Integer firstValue = arrayList.get(0);
            visited = new boolean[N + 1];

            Stack<Integer> stack = new Stack<>();
            stack.push(firstValue);

            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                visited[pop] = true;
                ArrayList<Integer> stacks = newArr[pop];

                if (stacks == null) {
                    continue;
                }
                for (int i = 0; i < stacks.size(); i++) {
                    if (!(stack.contains(stacks.get(i)) || visited[stacks.get(i)])) {
                        stack.push(stacks.get(i));
                    }
                }
            }

            for (int i = 1; i < visited.length; i++) {
                if (visited[i] == true) {
                    arrayList.remove(arrayList.indexOf(i));
                }
            }

            count++;
        }
        System.out.println(count);
    }
}