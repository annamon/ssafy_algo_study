package study_2021_10_week1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author anna
 * @date 2021.10.05
 * @summary 
 * BOJ-silver5  128MB/1s (13468KB/96ms)
 * 모음을 반드시 하나 포함하여야 한다.
 * 모음이 3개 연속 혹은 자음이 3개 연속 오면 안 된다.
 * 같은 글자가 연속으로 두 번 오면 안 되나 ee와 oo는 허용한다.
 */
public class Main_4659_비밀번호발음하기 {

	static String s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			s = br.readLine();
			if(s.equals("end")) break;
			boolean ok = true;
			if(!s.matches(".*[aeiou].*")) ok = false;
			if(s.matches(".*[aeiou]{3}.*")) ok = false;
			if(s.matches(".*[^aeiou]{3}.*")) ok = false;
			Pattern p = Pattern.compile("(\\w)\\1");
	        Matcher m = p.matcher(s);
	        while (m.find()) {
	            if (!(m.group(1).equals("e") || m.group(1).equals("o"))) {
	                ok = false;
	            }
	        }
			if(ok) System.out.println("<" + s + "> is acceptable.");
			else System.out.println("<" + s + "> is not acceptable.");
		}
	}

}
