import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] T = br.readLine().split("");

        Map<String, Integer> mapA = new HashMap<>();
        String[] a = br.readLine().split(" ");
        int cnta = a.length;
        for (int i = 0; i < a.length; i++) {
            mapA.put(a[i], i);
        }

//        System.out.println(mapA);

        Map<String, Integer> mapB = new HashMap<>();
        String[] b = br.readLine().split(" ");
        int cntb = b.length;
        for (int i = 0; i < b.length; i++) {
            mapB.put(b[i], i);
        }
//        System.out.println(mapB);


//        for (int i = 0; i < mapB.size(); i++) {
//            if (mapA.containsKey(mapB))
//                cnt++;
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            if (mapB.containsKey(mapA.get(i)))
//                cnt++;
//        }

        for (String A : b) {
            if (mapA.containsKey(A))
                cnta--;
        }
//            if (cnta == mapA.size())
//                cnta = 0;
//        }

        for (String B : a) {
            if (mapB.containsKey(B))
                cntb--;
        }
//            if (cntb == mapB.size())
//                cntb = 0;
//        }
        System.out.println(cnta + cntb);

    }
}
