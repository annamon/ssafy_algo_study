package study_2021_10_week1;

import java.io.*;

/**
 * @author anna
 * @date 2021.10.08
 * @summary 
 * BOJ-silver3  128MB/1s (13272KB/100ms)
 * 소문자 여러개와 별표로 이루어진 문자열
 * 별표는 빈 문자열로 바꾸기 가능
 * 패턴 일치시 DA, 불일치시 NE 출력
 * 
 * N : 파일 개수, 1~100
 */
public class Main_9996_한국이그리울땐서버에접속하지 {

	static int N;
	static String s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		pattern = pattern.replace("*", "[a-z]*");
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			if(s.matches(pattern)) System.out.println("DA");
			else System.out.println("NE");
		}
	}

}
