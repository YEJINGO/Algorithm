import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class PlanetEdge {
    int to;
    int weight;

    PlanetEdge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(prim(graph));
    }

    public static long prim(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<PlanetEdge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        visited[0] = true;
        for (int i = 0; i < n; i++) {
            if (graph[0][i] != 0) {
                pq.add(new PlanetEdge(i, graph[0][i]));
            }
        }

        long totalWeight = 0;
        while (!pq.isEmpty()) {
            PlanetEdge edge = pq.poll();
            if (visited[edge.to]) {
                continue;
            }
            visited[edge.to] = true;
            totalWeight += edge.weight;

            for (int i = 0; i < n; i++) {
                if (graph[edge.to][i] != 0 && !visited[i]) {
                    pq.add(new PlanetEdge(i, graph[edge.to][i]));
                }
            }
        }

        return totalWeight;
    }
}

