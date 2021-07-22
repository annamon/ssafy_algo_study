package study_2021_7_week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author anna
 * @date 2021.07.22
 * @summary 
 * BOJ-bronze2  256MB/1s (11648KB/88ms)
 * 문자열 N개 (1≤N≤100)
 * 문자열에 포함된 소문자, 대문자, 숫자, 공백 개수 구하기
 */
public class Main_10820_문자열분석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine()) != null) {
			int lower = 0;
			int upper = 0;
			int number = 0;
			int space = 0;
			for (int i = 0; i < s.length(); i++) {
				int c = s.charAt(i);
				if(c>=48 && c<=57) number++;
				else if(c>=65 && c<=90) upper++;
				else if(c>=97 && c<=122) lower++;
				else space++;
			}
			System.out.println(lower+" "+upper+" "+number+" "+space);
		}
	}

}
