
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력시 사용
        int num = Integer.parseInt(br.readLine()); // 몇개를 받을지 선언
        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" "); //" "를 기준으로 String을 잘라 배열에 삽입
            switch (str[0]) {
                case "push":
                    que.offer(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    if (que.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(que.poll()).append("\n");
                    break;
                case "front":
                    if (que.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(que.peek()).append("\n");
                    break;
                case "back":
                    if (que.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(que.peekLast()).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    if (que.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}


