
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]); // usun, ebed, acar
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for (int i = 0; i < strings.length; i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }
}