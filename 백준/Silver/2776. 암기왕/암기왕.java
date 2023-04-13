import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine()); //첫번째 줄은 테스트 개수
        for (int k = 0; k < T; k++) {


            int N = Integer.parseInt(br.readLine()); // 수첩1에 적어놓은 정수의 개수\
            String[] s = br.readLine().split(" ");
            Map<String, Integer> note1 = new HashMap<>();

            for (int i = 0; i < N; i++) {
                note1.put(s[i], 0);
            }

            
            int M = Integer.parseInt(br.readLine()); // 수첩2에 적어놓은 정수의 개수
            for (String note2 : br.readLine().split(" ")) {
                if (note1.containsKey(note2))
                    sb.append("1\n");
                else sb.append("0\n");
            }

        }
        System.out.println(sb);

    }

}