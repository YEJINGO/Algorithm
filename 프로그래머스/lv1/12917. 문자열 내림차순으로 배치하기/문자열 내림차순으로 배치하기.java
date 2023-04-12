import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }

        list.sort(Collections.reverseOrder());

        for (String element : list) {
            answer += element;
        }
        return answer;
    }
}