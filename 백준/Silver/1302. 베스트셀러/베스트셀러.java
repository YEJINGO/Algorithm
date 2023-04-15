import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<String, Integer>();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(s);
        }
//        System.out.println(list);


        // ArrayList 원소 빈도수를 Map 에 저장
        for (String str : list) {
            Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }
//        System.out.println(map);// {top=4, kimtop=1}


        Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), comparator);

        System.out.println(maxEntry.getKey());

    }
}

