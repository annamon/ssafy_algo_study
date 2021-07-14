package study_2021_7_week2;

import java.io.*;

/**
 * @author anna
 * @date 2021.07.15
 * @summary 
 * BOJ-bronze2  256MB/1s (11900KB/92ms)
 * Nemo 찾기. 대소문자 상관없음.
 * 니모를 찾으면 Found, 못 찾으면 Missing 출력
 * 입력 EOI인 경우 종료
 * 
 * find : 니모 찾은 경우
 */
public class Main_10173_니모를찾아서 {

	static boolean find;
	static String S = "^(?i)(nemo)$";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			find = false;
			String now = br.readLine();
			if(now.equals("EOI")) System.exit(0); //종료
			for (int i = 0; i < now.length()-4; i++) {	
				//n 이나 N으로 시작하는 경우 4문자 잘라서 비교
				if(now.charAt(i)=='n'||now.charAt(i)=='N') {
					if(now.substring(i, i+4).matches(S)) {
						find = true;
						break;
					}
				}
			}
			if(find)System.out.println("Found");
			else System.out.println("Missing");
		}
	}
}
