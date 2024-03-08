
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class PowerShortageEdge {
    int x;
    int y;
    int weight;

    PowerShortageEdge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }
            ArrayList<PowerShortageEdge> edges = new ArrayList<>();
            int totalCost = 0;
            int cost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges.add(new PowerShortageEdge(x, y, weight));
                totalCost += weight;

            }
            edges.sort(Comparator.comparing(edge -> edge.weight));

            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            int big = 0;
            for (int i = 0; i < edges.size(); i++) {
                PowerShortageEdge edge = edges.get(i);
                // 사이클 발생하는 간선 제외 == 부모가 같은 값 제외
                if (find(edge.x) != find(edge.y)) {
                    union(edge.x, edge.y);
                    cost += edge.weight;
                }
            }
            System.out.println(totalCost - cost);
        }
    }

    public static int find(int x) {
        // 값에 대한 부모 노드를 찾는다.
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}
