import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 정규표현식(Regular Expression)이란 문자열 데이터 중에서 원하는 조건(패턴)과 일치하는 문자열 부분을 찾아내기 위해 사용하는 것으로, 미리 정의된 기호와 문자를 이용해서 작성한 문자열
 * <p>
 * Pattern 클래스 : 문자열을 정규표현식 패턴 객체로 변환해주는 역할
 * Pattern 클래스는 일반 클래스처럼 공개된 생성자를 제공하지 않기 때문에, compile()정적 메소드를 호출해야 한다.
 * 이렇게 Pattern 객체로 컴파일된 정규식은 뒤의 Matcher 클래스에서 사용됨
 * <p>
 * Matcher 클래스 : 대상 문자열의 패턴을 해석하고, 주어진 패턴과 일치하는지 판별하고 반환된 필터링된 결과값들을 지니고 있음
 * Matcher 클래스도 공개된 생성자가 없어서 matcher() 메소드를 호출해서 얻는다.
 * <p>
 * Pattern.compile() 을 통해 정규식문자열을 패턴 객체로 변환
 * 패턴 객체에서 matcher() 메소드를 통해 문자열을 비교하고 검사한 결과값을 담은 매처 객체를 반환
 * 매처 객체에서 메소드로 원하는 결과값을 뽑음
 * Pattern.matches() 메소드는 단순히 참/거짓 만 결과를 반환하지만 Matcher 클래스의 group() 메소드를 통해 필터링된 문자열을 출력할수 있다
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 비교할 문자열
        String[] array = s.split("[\\s-]");
        int cnt = 0;

        String patternString = "^(c|j|n|m|t|s|l|d|qu)'[a|e|i|o|u|h]"; // 문자열 형태의 정규 표현식 문법

        // 1) 문자열 형태의 정규표현식 문법을 정규식 패턴으로 변환
        Pattern pattern = Pattern.compile(patternString);
        for (String word : array) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find() == true) {
                cnt += 2;
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}